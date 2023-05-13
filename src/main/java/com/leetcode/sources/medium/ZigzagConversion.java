package com.leetcode.sources.medium;

import java.util.*;

public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(result("PAYPALISHIRING", 5));
    }

    private static String result(String s, int numRows) {
        /*
        Input: s = "PAYPALISHIRING", numRows = 3
        Output: "PAHNAPLSIIGYIR"
        P   A   H   N
        A P L S I I G
        Y   I   R

        PAY P ALI S HIR I NG


        Input: s = "PAYPALISHIRING", numRows = 4
        Output: "PINALSIGYAHRPI"
        Explanation:
        P     I    N
        A   L S  I G
        Y A   H R
        P     I

        PAYP AL ISHI RI NG
        PAYP LA ISHI IR NG

        verticalLine: 선입선출 -> Queue
        zigzagLine: 후입선출 -> Stack

        Input: s = "A", numRows = 1
        Output: "A"

        P       H
        A     S I
        Y   I   R
        P L     I G
        A       N

        PAYPA LIS HIRIN G
        PAYPA SIL HIRIN G
        zigzagLineRow -> verticalLineRow - 2
         */

        int point = 0;
        List<List<Character>> list = new ArrayList<>();

        while (point < s.length()) {
            List<Character> firstList = new ArrayList<>();
            for (int i = 0; i < numRows & point < s.length(); i++) {
                firstList.add(s.charAt(point));
                point++;
            }
            int firstListTODO = numRows - firstList.size();
            for (int i = 0; i < firstListTODO; i++) {
                firstList.add(Character.MIN_VALUE);
            }

            List<Character> secondList = new ArrayList<>();
            for (int i = 0; i < numRows - 2 & point < s.length(); i++) {
                secondList.add(s.charAt(point));
                point++;
            }
            secondList.add(0, Character.MIN_VALUE);
            int secondListTODO = numRows - secondList.size();
            for (int i = 0; i < secondListTODO; i++) {
                secondList.add(Character.MIN_VALUE);
            }
            Collections.reverse(secondList);
            list.add(firstList);
            list.add(secondList);
        }

        /*
        PAYPA
        0LIS0
        HIRIN
        000G0
         */

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (List<Character> characters : list) {
                Character character = characters.get(i);
                if (character != 0) {
                    sb.append(character);
                }
            }
        }
        return sb.toString();
    }

}
