package com.example.sqldemo.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringOperation {

    public static String reverseString(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    public static String removeLastCharacterFromString(String text) {
//        return new StringBuilder(text).deleteCharAt(text.length() - 1).toString();

        //Using SubString
        return text.substring(0, text.length() - 1);
    }

    //Write a function to find the longest common prefix string amongst an array of strings.
    public static String findLongestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s = strs[0];
        String s1 = strs[strs.length - 1];

        int index = 0;

        String commonString = "";

        while (index < s.length() && index < s1.length()) {
            if (s.charAt(index) != s1.charAt(index)) {
                break;
            }
            commonString = commonString + s.charAt(index);
            index++;
        }
        return commonString;
    }

    /*
    * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
 */

    public static boolean checkValidParenthesis(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");

        boolean valid = false;

        if (s.length() % 2 != 0) {
            return false;
        }

        int index = 0;
        while (index < s.length()) {
            String character = Character.toString(s.charAt(index));
            if (!map.containsKey(character) || !map.get(character).equals(Character.toString(s.charAt(index + 1)))) {
                return false;
            }
            valid = true;
            index = index + 2;
        }
        return valid;
    }

    public static boolean isStringAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        s1 = new String(chars);

        chars = s2.toCharArray();
        Arrays.sort(chars);
        s2 = new String(chars);

        return s1.equals(s2);
    }

    public static Map<String, Integer> countNumberOfOccurrencesInWord(String input) {
        System.out.println(input);
        String[] words = input.split(" ");

        System.out.println(words);

        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            System.out.println("Checking word : " + s);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);
        return map;
    }

    public static boolean winnerOfGame(String colors) {
        Map<String, Integer> count = new HashMap<>();
        count.put("A", 0);
        count.put("B", 0);

        if (colors.length() <= 2) {
            return false;
        }
        for (int i = 1; i < colors.length() - 1; i++) {
            String currentChar = Character.toString(colors.charAt(i));
            String previousChar = Character.toString(colors.charAt(i - 1));
            String nextChar = Character.toString(colors.charAt(i + 1));

            if (currentChar.equalsIgnoreCase("A") && previousChar.equalsIgnoreCase("A") && nextChar.equalsIgnoreCase("A")) {
                count.put("A", count.getOrDefault("A", 0) + 1);
            } else if (currentChar.equalsIgnoreCase("B") && previousChar.equalsIgnoreCase("B") && nextChar.equalsIgnoreCase("B")) {
                count.put("B", count.getOrDefault("B", 0) + 1);
            }
        }

        return count.get("A") > count.get("B");
    }

    public static String reverseWords(String s) {
        String[] words = s.split("\\s");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i != 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(new StringBuilder(words[i]).reverse());
        }
        return stringBuilder.toString();
    }

    public static long appealSum(String s) {
        int count = 0;

        int i = 1;
        while (i <= s.length()) {

            System.out.println("Checking length : " + i);

            for (int j = 0; j < s.length(); j++) {
                StringBuilder builder = new StringBuilder();
                System.out.println("Checking j : " + j);

                int startIndex = j;
                int endIndex = j + i;
                while (endIndex <= s.length() && builder.length() <= s.length()) {
                    builder.append(s, startIndex, endIndex);
                    startIndex = endIndex;
                    endIndex = endIndex + i + 1;
                }
                String string = builder.chars()
                        .distinct()
                        .mapToObj(ch -> String.valueOf((char) ch))
                        .collect(Collectors.joining());

                System.out.println("String : " + string);

                count = count + string.length();
            }

            i++;
        }
        return count;
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static boolean isPalindrome(String s) {
        String result = s.replaceAll("[^a-zA-Z]","");
        return result.contentEquals(new StringBuilder(result).reverse());
    }

    public static boolean isSubsequence(String s, String t) {
        if (!t.contains(String.valueOf(s.charAt(0)))) {
            return false;
        }
        int startIndex = t.indexOf(s.charAt(0));
        int index = 1;

        boolean subSequence = true;

        while (index < s.length()) {
            if (!t.contains(String.valueOf(s.charAt(index))) || startIndex > t.indexOf(s.charAt(index), startIndex + 1)) {
                return false;
            }
            startIndex = t.indexOf(s.charAt(index), startIndex);
            index++;
        }
        return true;
    }

    public static String removeTrailingZero(String s) {
        /*int lastIndex = 0;
        for (int i = s.length() - 1 ; i >= 0 ; i--) {
            if (s.charAt(i) != 0) {
                lastIndex = i;
                break;
            }
        }
        return s.substring(0, lastIndex);*/

        StringBuilder builder = new StringBuilder(s);
        for (int i = s.length() - 1 ; i >= 0 ; i--) {
            if (s.charAt(i) != 0) {
                break;
            }
            builder.deleteCharAt(i);
        }
        return builder.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                builder.deleteCharAt(i - 1);
                builder.deleteCharAt(i);
            }
        }
        s = builder.toString();

        builder = new StringBuilder(t);
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                builder.deleteCharAt(i - 1);
                builder.deleteCharAt(i);
            }
        }
        t = builder.toString();

        return s.equals(t);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!magazine.contains(Character.toString(ransomNote.charAt(i)))) {
                return false;
            }
            magazine = new StringBuilder(magazine).deleteCharAt(magazine.indexOf(ransomNote.charAt(i))).toString();
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] s1 = new int[s.length()];
        int[] t1 = new int[t.length()];

        StringBuilder replacedString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

        }

        return replacedString.toString().equals(t);
    }

    /*
    * Given a pattern and a string s, find if s follows the same pattern.

        Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



        Example 1:

        Input: pattern = "abba", s = "dog cat cat dog"
        Output: true
        Example 2:

        Input: pattern = "abba", s = "dog cat cat fish"
        Output: false
        Example 3:

        Input: pattern = "aaaa", s = "dog cat cat dog"
        Output: false
 */

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            String text = map.getOrDefault(Character.toString(pattern.charAt(i)), words[i]);
            System.out.println(text);
            if (!words[i].equals(text) || (!map.containsKey(Character.toString(pattern.charAt(i))) && map.containsValue(words[i]))) {
                return false;
            }
            System.out.println("Char : "+ Character.toString(pattern.charAt(i)) + "Words : "+ words[i]);
            map.put(Character.toString(pattern.charAt(i)), words[i]);
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < t.length(); i++) {
            if (!s.contains(Character.toString(t.charAt(i)))) {
                return false;
            }
            s = new StringBuilder(s).deleteCharAt(s.indexOf(t.charAt(i))).toString();
        }
        return s.isEmpty();
    }
}
