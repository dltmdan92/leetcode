package com.leetcode.sources.programmers;

public class Test20230506_01 {

    public static void main(String[] args) {
        System.out.println(solution("90876543210"));
    }

    private static int solution(String number) {

        int answer = 0;

        /*
        int index
        12156
        isSerial(number, index) ? true : index + 2 & answer + 1: index + 1 & answer + 2
        12 -> isSerial = true,  index + 2 = 2, answer + 1 = 1
        1 -> isSerial = false, index + 1 = 3, answer + 2 = 3
        56 -> isSerial = true, index + 2 = 5, answer + 1 = 4

        12157
        12 -> isSerial = true, index + 2 = 2, answer + 1 = 1
        1 -> isSerial = false, index + 1 = 3, answer + 2 = 3
        5 -> isSerial = false, index + 1 = 4, answer + 2 = 5
        7 -> isSerial = false (last index), index + 1 = 5, answer + 2 = 7

        100
        1 -> isSerial = false, index + 1 = 1, answer + 2 = 2
        0 -> isZero = true, index + 1 = 2, answer + 1 = 3
        0 -> isZero = true, index + 1 = 3, answer + 1 = 4

        while (index < number.length())
         */

        int index = 0;

        while (index < number.length()) {
            if (isZero(number, index)) {
                index++;
                answer++;
            } else if (isSerial(number, index)) {
                index+=2;
                answer++;
            } else {
                index++;
                answer+=2;
            }
        }

        return answer;
    }

    private static boolean isZero(String number, int index) {
        return Integer.parseInt(String.valueOf(number.charAt(index))) == 0;
    }

    private static boolean isSerial(String number, int index) {
        if (index >= number.length() - 1) {
            // last index
            return false;
        }
        int beforeNum = Integer.parseInt(String.valueOf(number.charAt(index)));
        int afterNum = Integer.parseInt(String.valueOf(number.charAt(index+1)));

        if (beforeNum == 9 && afterNum == 0) {
            return true;
        }
        return beforeNum + 1 == afterNum;
    }

}
