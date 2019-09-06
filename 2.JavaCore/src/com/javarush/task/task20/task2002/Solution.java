package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("C:\\Users\\Алексей\\Desktop\\тест\\1.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setFirstName("Петя");
            user1.setLastName("Петров");
            user1.setBirthDate(format.parse("22 01 2000"));
            user1.setMale(true);
            user1.setCountry(User.Country.OTHER);
            javaRush.users.add(user1);
            User user2 = new User();
            user2.setFirstName("Алексей");
            user2.setLastName("Коваленко");
            user2.setBirthDate(format.parse("24 01 1993"));
            user2.setMale(true);
            user2.setCountry(User.Country.OTHER);
            javaRush.users.add(user2);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            String isUser = users.size() > 0 ? "yes" : "no";
            writer.println(isUser);
            if(isUser.equals("yes")){
                for(User u : users){
                    SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
                    writer.println(u.getFirstName() == null ? "null" : u.getFirstName());
                    writer.println(u.getLastName() == null ? "null" : u.getLastName());
                    writer.println(u.getBirthDate() == null ? "null" : Long.toString(u.getBirthDate().getTime()));
                    writer.println(u.isMale());
                    writer.println(u.getCountry() == null ? "null" : u.getCountry());
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            if(reader.readLine().equals("yes")){
                while(reader.ready()){
                    User user = new User();
                    String s = reader.readLine();
                    String firstName = (s.equals("null") ? null : s);
                    s = reader.readLine();
                    String lastName = (s.equals("null") ? null : s);
                    s= reader.readLine();
                    Date birthday = new Date((s.equals("null") ? null : Long.parseLong(s)));
                    s = reader.readLine();
                    boolean isMale = Boolean.valueOf(s);
                    user.setBirthDate(birthday);
                    user.setCountry(User.Country.valueOf(reader.readLine()));
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setMale(isMale);
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
