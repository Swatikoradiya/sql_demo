package com.example.sqldemo.dsa;

public class IntOperation {

    /*
    * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

    You must not use any built-in exponent function or operator.

    For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.


    Example 1:

    Input: x = 4
    Output: 2
    Explanation: The square root of 4 is 2, so we return 2.
    Example 2:

    Input: x = 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 */
    public static int mySqrt(int x) {
        return (int) Math.floor(Math.sqrt(x));
    }

    /*  Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.

        Return the maximum product you can get.



        Example 1:

        Input: n = 2
        Output: 1
        Explanation: 2 = 1 + 1, 1 × 1 = 1.
        Example 2:

        Input: n = 10
        Output: 36
        Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */
    public static int integerBreak(int n) {
        if (n <= 3) {
            return n-1;
        }
        int ans = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3,ans);
        } else if (remainder == 1) {
            return (int) (Math.pow(3, ans - 1) * 4);
        } else {
            return (int) (Math.pow(3, ans) * 2);
        }
    }

    /*
    * Write an algorithm to determine if a number n is happy.

        A happy number is a number defined by the following process:

        Starting with any positive integer, replace the number by the sum of the squares of its digits.
        Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
        Those numbers for which this process ends in 1 are happy.
        Return true if n is a happy number, and false if not.



        Example 1:

        Input: n = 19
        Output: true
        Explanation:
        12 + 92 = 82
        82 + 22 = 68
        62 + 82 = 100
        12 + 02 + 02 = 1
        Example 2:

        Input: n = 2
        Output: false
 */
    public boolean isHappy(int n) {
        while (n > 4) {
            int sum = 0;
            int num = n;

            while (num > 0) {
                int digit = n % 10;
                sum = sum + (digit * digit);
                num = num / 10;
            }

            n = sum;
            System.out.println(n);
        }
        return n == 1;
    }
}
