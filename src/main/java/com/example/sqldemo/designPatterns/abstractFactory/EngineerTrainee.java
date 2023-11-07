package com.example.sqldemo.designPatterns.abstractFactory;

import com.example.sqldemo.designPatterns.FactoryPattern.Profession;

public class EngineerTrainee implements Profession {

    @Override
    public void print() {
        System.out.println("Trainee Engineer");
    }
}
