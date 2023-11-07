package com.example.sqldemo.dsa;

import java.util.HashMap;
import java.util.Map;

public class CountDigitInNumber {

    public static int countTotalDigitInNumber(int number) {
        number = Math.abs(number);

        int count = 0;
        while (number > 0) {
            number = number / 10;
            count++;
        }

        return count;
    }

    public static int countTotalDigitInNumber(String number) {
        return number.length();
    }

    public static int countNumberOfTimeRepeatDigitInNumber(int input, int number) {
        number = Math.abs(number);

        int count = 0;
        while (input > 0) {
            int num = input % 10;

            if (num == number) {
                count++;
            }
            input = input / 10;
        }
        return count;
    }

    public static int countNumberOfTimeRepeatDigitInNumber(String input, int number) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.getNumericValue(input.charAt(i)) == number) {
                count++;
            }
        }
        return count;
    }

    public static int countNumberOfTimeRepeatStringInString(String input, String string) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.toString(input.charAt(i)).equals(string)) {
                count++;
            }
        }
        return count;
    }

    public static Map<String, Integer> countAllStringInString(String input) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            map.put(String.valueOf(input.charAt(i)), map.getOrDefault(String.valueOf(input.charAt(i)), 0) + 1);
        }
        return map;
    }

    public static int countOccurrencesOfSubString(String input, String targetInput) {
        int index = input.indexOf(targetInput);

        int count = 0;
        while (index != -1) {
            index = input.indexOf(targetInput, index + 1);
            count++;
        }
        return count;
    }

    public static int getLastDigitFromNumber(int number) {
        return number % 10;
    }

    public static int removeLastDigitFromNumber(int number) {
        return number / 10;
    }

    public static int reverseNumber(int number) {
        int reverseNum = 0;
        while (number > 0) {
            int lastNum = number % 10;
            reverseNum = reverseNum * 10 + lastNum;
            number = number / 10;
        }
        return reverseNum;
    }
}
