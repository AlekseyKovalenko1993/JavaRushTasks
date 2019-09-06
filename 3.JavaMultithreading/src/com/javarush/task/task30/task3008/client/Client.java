package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() throws IOException {
        return ConsoleHelper.readString();
    }

    protected int getServerPort() throws IOException{
        return ConsoleHelper.readInt();
    }

    protected String getUserName() throws IOException{
        System.out.println("Entry your name");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        }catch (IOException e){
            clientConnected = false;
            System.out.println("Message don't send");
        }
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this){
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println("Error");
            }
        }
        if(clientConnected)
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        while (clientConnected){
            String message = ConsoleHelper.readString();
            if(message.equals("exit")){
                break;
            }
            if(shouldSendTextFromConsole())
                sendTextMessage(message);
        }
    }


    public class SocketThread extends Thread{
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " Присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " Покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true){
               Message message = connection.receive();
               if(message.getType() == MessageType.NAME_REQUEST){
                   connection.send(new Message(MessageType.USER_NAME, Client.this.getUserName()));
               }else if(message.getType() == MessageType.NAME_ACCEPTED){
                   notifyConnectionStatusChanged(true);
                   break;
               }else
                   throw new IOException("Unexpected MessageType");
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT){
                    processIncomingMessage(message.getData());
                }else if(message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                }else if(message.getType() == MessageType.USER_REMOVED){
                    informAboutDeletingNewUser(message.getData());
                }else
                    throw new IOException("Unexpected MessageType");
            }
        }

        @Override
        public void run() {
            try {
                String socketname = Client.this.getServerAddress();
                int port = getServerPort();
                Socket socket = new Socket(socketname, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }catch (IOException e){
                notifyConnectionStatusChanged(false);
            }catch (ClassNotFoundException e){
                notifyConnectionStatusChanged(false);
            }
        }
    }

    public static void main(String[] args) {
        new Client().run();
    }
}
