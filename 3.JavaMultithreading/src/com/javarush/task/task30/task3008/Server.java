package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String,Connection> pair : connectionMap.entrySet()){
            try{
                pair.getValue().send(message);
            }catch (IOException e){
                System.out.println("Your message has not delivered");
            }
        }
    }

    public static void main(String[] args) throws IOException{
        int port = ConsoleHelper.readInt();
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            while (true) {
                Socket socket = server.accept();
                Handler hundler = new Handler(socket);
                hundler.start();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            server.close();
        }
    }
    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            Message message = null;
            String userName = null;
            while(userName == null || userName.isEmpty() || message.getType() != MessageType.USER_NAME || connectionMap.containsKey(userName)) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();
                userName = message.getData();
            }
            connectionMap.put(userName,connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return userName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for(String nameUsercon : connectionMap.keySet()){
                 if(!nameUsercon.equals(userName)){
                     connection.send(new Message(MessageType.USER_ADDED,nameUsercon));
                 }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT) {
                    String newmessage = String.format("%s: %s",userName,message.getData());
                    sendBroadcastMessage(new Message(MessageType.TEXT,newmessage));
                }else
                    ConsoleHelper.writeMessage(userName + "' Message isn't text");
            }
        }

        @Override
        public void run()  {
            String userName = null;
            System.out.println("Connected socket = " + socket.getRemoteSocketAddress());
            try(Connection connection = new Connection(socket)){
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            }catch (IOException e){
                System.out.println("Ошибка при передачи удаленных данных");
            }catch (ClassNotFoundException e){
                System.out.println("Ошибка при передачи удаленных данных");
            }finally {
                if(userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
                }
            }
        }
    }

}
