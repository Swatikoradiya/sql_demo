package com.example.sqldemo.designPatterns.FactoryPattern;

public class Doctor implements Profession{

    @Override
    public void print() {
        System.out.println("Doctor class");
    }
}
