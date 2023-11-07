package com.example.sqldemo.dsa;

import java.util.*;

public class BuyAndSellStock {

    public static void buyAndSellStock(int[] prices) {
        int min = prices[0];
        int max = prices[0];
        int minDay = 0;
        int maxDay = 0;

        for (int i = 0; i < prices.length; i++) {
            int minNum = Math.min(min, prices[i]);
            if (minNum != min) {
                min = minNum;
                minDay = i + 1;
            }

            int maxNum = Math.max(max, prices[i]);

            if (maxNum != max) {
                max = maxNum;
                maxDay = i + 1;
            }
        }

        System.out.println("Lowest Price is on day : " + minDay + "and Price is : " + min);
        System.out.println("Highest Price is on day : " + maxDay + "and Price is : " + max);
    }

    /*
    * You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



    Example 1:

    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
    Example 2:

    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.*/
    public static int maxProfit(int[] prices) {
        int minValue = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
            minValue = Math.min(minValue, prices[i]);
        }

        return maxProfit;
    }

    public static int maximumProfit(int[] prices) {
        int oldPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < oldPrice) {
                oldPrice = prices[i];
            }
            else {
                maxProfit = maxProfit + prices[i] - oldPrice;
                oldPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
