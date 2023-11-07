package com.example.sqldemo.designPatterns.singletone;

public class SingleTone {

    private static SingleTone singleTone = new SingleTone(); // THis is called Eager Loading in Lazy Loading here we don't need to initialize anything.

    private SingleTone() {
    }

    public static SingleTone getInstance() {

        /* This is called Lazy Loading
        if (singleTone == null) {
            singleTone = new SingleTone();
        }*/
        return singleTone;
    }

    public void simpleMethod() {
        System.out.println("Hash code of singletone class "+ singleTone);
    }
}
