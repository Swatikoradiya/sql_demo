package com.example.sqldemo.designPatterns.abstractFactory;

import com.example.sqldemo.designPatterns.FactoryPattern.Profession;

public abstract class AbstractFactory {

    public abstract Profession getProfession(String type);

}
