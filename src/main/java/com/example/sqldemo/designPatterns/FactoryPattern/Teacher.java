package com.example.sqldemo.designPatterns.FactoryPattern;

public class Teacher implements Profession{
    @Override
    public void print() {
        System.out.println("Teacher class");
    }
}
