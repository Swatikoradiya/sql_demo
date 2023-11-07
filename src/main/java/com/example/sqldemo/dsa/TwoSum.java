package com.example.sqldemo.dsa;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.internal.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TwoSum {

    public static void sumInArray(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (j != i) {
                    int sum = numbers[i] + numbers[j];
                    if (target == sum) {
                        Pair<Integer, Integer> pair = Pair.of(i, j);
                        log.info("Pair  left : {}, Pair right : {}", pair.getLeft(), pair.getRight());
                        break;
                    }
                }
            }
        }
    }

    public static void sumInArrayUsingHashMap(int[] numbers, int target) {
        Map<Integer, Integer> input = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            input.put(numbers[i], i);
        }

        //Using HashMap
       /* for (int i = 0; i < numbers.length; i++) {
            int secondNum = target - numbers[i];
            if (input.containsKey(secondNum)) {
                Pair<Integer, Integer> pair = Pair.of(i, input.get(secondNum));
                log.info("Pair  left : {}, Pair right : {}", pair.getLeft(), pair.getRight());
                break;
            }
        }*/

        //Using Stream
        Pair<Integer, Integer> pairs = Arrays.stream(numbers)
                .boxed()
                .map(num -> Pair.of(num, target - num))
                .filter(pair -> input.containsKey(pair.getRight()))
                .findFirst()
                .map(pair -> Pair.of(input.get(pair.getLeft()), input.get(pair.getRight())))
                .get();

        log.info("Pair  left : {}, Pair right : {}", pairs.getLeft(), pairs.getRight());

        numbers = Arrays.stream(numbers).sorted().toArray();
        log.info("Sorted Number : {}", numbers);

        int maxSum = numbers[numbers.length - 1];

        int[] finalNumbers = numbers;
        pairs = Arrays.stream(numbers)
                .boxed()
                .flatMap(num -> Arrays.stream(finalNumbers)
                        .boxed()
                        .filter(num2 -> !num2.equals(num))
                        .map(num2 -> Pair.of(num, num2)))
                .max(Comparator.comparingInt(pair -> pair.getLeft() + pair.getRight()))
                .orElse(Pair.of(-1,-1));

        log.info("Pair  left : {}, Pair right : {}", pairs.getLeft(), pairs.getRight());

    }
}
