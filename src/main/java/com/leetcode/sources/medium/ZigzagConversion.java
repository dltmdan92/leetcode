package com.leetcode.sources.medium;

import java.util.*;

public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(result("PAYPALISHIRING", 4));
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

        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = numRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

}
