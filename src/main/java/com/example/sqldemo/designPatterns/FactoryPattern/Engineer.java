package com.example.sqldemo.designPatterns.FactoryPattern;

public class Engineer implements Profession{

    @Override
    public void print() {
        System.out.println("Engineer class");
    }
}
