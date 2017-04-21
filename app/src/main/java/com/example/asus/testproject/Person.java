package com.example.asus.testproject;

/**
 * Created by ASUS on 4/21/2017.
 */

public class Person {
    int id;
    String name;
    String roll;
    String subject;

    public Person(int id, String name, String roll, String subject) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roll='" + roll + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
