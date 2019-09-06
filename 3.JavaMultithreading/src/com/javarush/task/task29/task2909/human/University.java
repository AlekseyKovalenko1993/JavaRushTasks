package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public void setStudents(List<Student> student) {
        this.students = student;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for(Student student : students){
            if(student.getAverageGrade() == averageGrade)
                return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        ArrayList<Student> copy = new ArrayList<>();
        copy.addAll(students);
        Collections.sort(copy, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -Double.compare(o1.getAverageGrade(),o2.getAverageGrade());
            }
        });
        return copy.get(0);
    }

    public Student getStudentWithMinAverageGrade(){
        ArrayList<Student> copy = new ArrayList<>();
        copy.addAll(students);
        Collections.sort(copy, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getAverageGrade(),o2.getAverageGrade());
            }
        });
        return copy.get(0);
    }
    public void expel(Student student){
        students.remove(student);
    }
}