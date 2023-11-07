package com.example.sqldemo.designPatterns.abstractFactory;

import com.example.sqldemo.designPatterns.FactoryPattern.Profession;

public class TraineeTeacher implements Profession {
    @Override
    public void print() {
        System.out.println("Trainee Teacher");
    }
}
