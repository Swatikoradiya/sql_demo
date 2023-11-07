package com.example.sqldemo.designPatterns.FactoryPattern;

import com.example.sqldemo.designPatterns.abstractFactory.AbstractFactory;

public class ProfessionFactory extends AbstractFactory {

    @Override
    public Profession getProfession(String type) {
        return switch (type) {
            case "Teacher" -> new Teacher();
            case "Engineer" -> new Engineer();
            case "Doctor" -> new Doctor();
            default -> null;
        };
    }
}
