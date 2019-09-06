package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LogParser implements IPQuery {
    private Path logDir;
    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyyy HH:mm:ss");


    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after,before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getListDate(after,before).stream().map(s -> getIp(s)).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getListDate(after,before).stream().filter(s -> getUset(s).equals(user)).map(s -> getIp(s)).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getListDate(after,before).stream().filter(s -> getEvent(s).equals(event.toString()))
                .map(s -> getIp(s)).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getListDate(after,before).stream().filter(s -> getStatus(s).equals(status.toString()))
                .map(s -> getIp(s)).collect(Collectors.toSet());
    }

    private List<String> getListDate(Date after,Date before){
        ArrayList<String> result = new ArrayList<>();
        for(File file : logDir.toFile().listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".log");
            }
        })) {
            try {
                List<String> list = Files.readAllLines(file.toPath());
                if (after == null && before == null)
                    result.addAll(list);
                else if (after == null) {
                    result.addAll(list.stream().filter(s -> getDate(s).getTime() <= before.getTime()).collect(Collectors.toList()));
                } else if (before == null) {
                    result.addAll(list.stream().filter(s -> getDate(s).getTime() >= after.getTime()).collect(Collectors.toList()));
                } else
                    result.addAll(list.stream().filter(s -> getDate(s).getTime() >= after.getTime() && getDate(s).getTime() <= before.getTime())
                            .collect(Collectors.toList()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static String getStatus(String s){
        return s.split("\\t")[4];
    }

    private static String getEvent(String s){
        return s.split("\\t")[3];
    }

    private static String getIp(String s){
        return s.split("\\t")[0];
    }

    private static Date getDate(String s){
        Date date = null;
        try {
            date = format.parse(s.split("\\t")[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getUset(String s){
        return s.split("\\t")[1];
    }
}