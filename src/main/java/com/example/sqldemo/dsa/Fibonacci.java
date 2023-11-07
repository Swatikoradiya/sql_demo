package com.example.sqldemo.dsa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fibonacci {

    //To print Fibonacci series formula will be n = (n-1) + (n-2)
    //so we can get 0,1,1,2,3,5,8,13....
    public static int printNthFibonacciNumber(int totalFibonacciNumber) {
        int a = 0;
        int b = 1;

        if (totalFibonacciNumber < 0) {
            throw new RuntimeException("Inputs can not be negative");
        }
        if (totalFibonacciNumber == 0) {
            return a;
        } else if (totalFibonacciNumber == 1) {
            return b;
        }

        int c = 0;
        for (int i = 2; i < totalFibonacciNumber; i++) {
            c = a + b;
            System.out.println("Number is : "+c);
            a = b;
            b = c;
        }

        return c;
    }

    public static int printNthFibonacciNumber(int totalFibonacciNumber, int indexOfNumber) {
        int a = 0;
        int b = 1;

        if (totalFibonacciNumber < 0) {
            throw new RuntimeException("Inputs can not be negative");
        }
        if (totalFibonacciNumber == 0) {
            return a;
        } else if (totalFibonacciNumber == 1) {
            return b;
        }

        int c = 0;
        List<Integer> integerList = new ArrayList<>();
        integerList.add(a);
        integerList.add(b);

        for (int i = 2; i < totalFibonacciNumber; i++) {
            c = a + b;
            System.out.println("Number is : "+c);
            a = b;
            b = c;

            integerList.add(c);
        }

        System.out.println(integerList);
        return integerList.get(indexOfNumber);
    }
}
