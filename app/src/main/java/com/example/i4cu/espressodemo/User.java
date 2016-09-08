package com.example.i4cu.espressodemo;

/**
 * Created by Quan Bui on 07/09/2016.
 */
public class User {

    private String name;

    private int age;

    public User() {
        //empty constructor
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
