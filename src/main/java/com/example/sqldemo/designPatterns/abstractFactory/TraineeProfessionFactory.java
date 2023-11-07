package com.example.sqldemo.designPatterns.abstractFactory;

import com.example.sqldemo.designPatterns.FactoryPattern.Profession;

public class TraineeProfessionFactory extends AbstractFactory{

    @Override
    public Profession getProfession(String type) {
        return switch (type) {
            case "Teacher" -> new TraineeTeacher();
            case "Engineer" -> new EngineerTrainee();
            default -> null;
        };
    }
}
