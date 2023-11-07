package com.example.sqldemo.dsa;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RomanToInteger {

    public static int convertRomanToInt(String romanNum) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

//        List<Integer> integers = new LinkedList<>();

        int sum = 0;
        int previous = 0;

        for (int i = 0; i < romanNum.length(); i++) {
            String character = Character.toString(romanNum.charAt(i));

            int value = map.get(character);

            if (previous < value) {
                sum = sum - value;
            }
            else {
                sum = sum + value;
            }
        }
        return sum;
    }
}
