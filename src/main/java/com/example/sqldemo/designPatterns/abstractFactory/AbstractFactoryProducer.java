package com.example.sqldemo.designPatterns.abstractFactory;

import com.example.sqldemo.designPatterns.FactoryPattern.ProfessionFactory;

public class AbstractFactoryProducer {

    public static AbstractFactory getProfession(boolean isTrainee) {
        if (isTrainee) {
            return new TraineeProfessionFactory();
        }
        return new ProfessionFactory();
    }
}
