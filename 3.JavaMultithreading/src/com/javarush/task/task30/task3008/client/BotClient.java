package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class BotClient extends Client{

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() throws IOException {
        return "date_bot_" + (int)(Math.random()*100);
    }

    public static void main(String[] args) {
        new BotClient().run();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            BotClient.this.sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
            String[] income = message.split(":");
            if(income.length != 2 ||income[0] == null || income[1] == null){
                return;
            }
            String username = income[0];
            SimpleDateFormat format;
            Date currDateTime = new GregorianCalendar().getTime();
            switch(income[1].trim()){
                case "дата":{
                    format = new SimpleDateFormat("d.MM.YYYY");
                    sendTextMessage(String.format("Информация для %s: %s", income[0], format.format(currDateTime)));
                    break;
                }
                case "день":{
                    format = new SimpleDateFormat("d");
                    sendTextMessage(String.format("Информация для %s: %s", income[0], format.format(currDateTime)));
                    break;
                }
                case "месяц":{
                    format = new SimpleDateFormat("MMMM");
                    sendTextMessage(String.format("Информация для %s: %s", income[0], format.format(currDateTime)));
                    break;
                }
                case "год":{
                    format = new SimpleDateFormat("YYYY");
                    sendTextMessage(String.format("Информация для %s: %s", income[0], format.format(currDateTime)));
                    break;
                }
                case "время":{
                    format = new SimpleDateFormat("H:mm:ss");
                    sendTextMessage(String.format("Информация для %s: %s", income[0], format.format(currDateTime)));
                    break;
                }
                case "час":{
                    format = new SimpleDateFormat("H");
                    sendTextMessage(String.format("Информация для %s: %s", income[0], format.format(currDateTime)));
                    break;
                }
                case "минуты":{
                    format = new SimpleDateFormat("m");
                    sendTextMessage(String.format("Информация для %s: %s", income[0], format.format(currDateTime)));
                    break;
                }
                case "секунды":{
                    format = new SimpleDateFormat("s");
                    sendTextMessage(String.format("Информация для %s: %s", income[0], format.format(currDateTime)));
                    break;
                }
            }
        }
    }
}
