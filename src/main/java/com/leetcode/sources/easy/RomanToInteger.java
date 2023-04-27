package com.leetcode.sources.easy;

import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        /**
         * IV: 4
         * IX: 9
         *
         * XL: 40
         * XC: 90
         *
         * CD: 400
         * CM: 900
         *
         * I: 1
         * V: 5
         * X: 10
         * L: 50
         * C: 100
         * D: 500
         * M: 1000
         */
        System.out.println(romanToInt("LVIII"));
    }

    private static int romanToInt(String s) {
        Map<Character, Integer> soloCases = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int before = 0;
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (before > soloCases.get(c)) {
                result -= soloCases.get(c);
            } else {
                result += soloCases.get(c);
                before = soloCases.get(c);
            }
        }

        return result;
    }

}
