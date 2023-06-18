package com.leetcode.sources.medium;

/**
 * https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
    }

    private static int divide(int dividend, int divisor) {
        boolean minus = false;
        boolean dividendover = false;
        boolean divisorover = false;
        if ((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0)) {
            minus = true;
        }

        int count = 0;

        if (divisor != -2147483648) {
            divisor = Math.abs(divisor);
        } else {
            divisor = 2147483647;
            divisorover = true;
        }

        if (dividend != -2147483648) {
            dividend = Math.abs(dividend);
        } else {
            dividend = 2147483647;
            dividendover = true;
        }

        while (dividend >= divisor) {
            dividend-=divisor;
            count++;
        }

        if (minus) {
            if ((dividendover && !divisorover) || (!dividendover && divisorover)) {
                System.out.printf("dividend : %d, divisor : %d\n", count, divisor);
                if (divisor > count) {
                    return 0;
                }
                System.out.println("minus over");
                return -count-1;
            }
            return -count;
        } else {
            return count;
        }
    }

}
