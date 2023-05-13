package com.leetcode.sources.medium;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-12345607));
    }

    private static int reverse(int x) {

        int multiple = String.valueOf(x).length() - 1;

        long result = 0;
        boolean minus = x < 0;

        if (minus) {
            while (x < 0) {
                double current = (x % 10) * Math.pow(10, multiple);
                result += current;
                x = x / 10;
                multiple--;
            }
        } else {
            while (x > 0) {
                double current = (x % 10) * Math.pow(10, multiple);
                result += current;
                x = x / 10;
                multiple--;
            }
        }

        if (minus) {
            result = result / 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) result;

    }

}
