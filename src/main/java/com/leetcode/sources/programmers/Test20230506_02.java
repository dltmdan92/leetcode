package com.leetcode.sources.programmers;

public class Test20230506_02 {

    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    private static int solution(int n) {
        /*
        n = 10
        10
        9 1 = 9 * 2 = 18
        8 2


        2 1 -> a = 3, h = 2
        3 1 -> a = 4, h = 2
        4 1 -> a = 5, h = 2
        3 2 -> a = 5, h = 2

        3 2 1 -> a = 6, h = 3
        4 2 1 a = 7
        4 3 1 a = 8
        4 3 2  a = 9

        4 3 2 1 a= 10, h = 4
        5 3 2 1 a = 11, h = 4
        5 4 2 1


        n = 5
        5
        4 1
        3 2

        n = 3
        3 = 3
        2 1 = 2 * 2 = 4
         */

        if (n <= 1) {
            return 1;
        }

        int answer = 0;

        for (int base = n - 1; base >= 1; base--) {
            int maxHeightOfBase = getMaxHeightOfBase(n, base);
            answer = Math.max(answer, base * maxHeightOfBase);
        }
        return answer;
    }

    private static int getMaxHeightOfBase(int n, int base) {
        int availables = n - base;
        return getHeightOfAvailables(availables) + 1;
    }

    private static int getHeightOfAvailables(int availables) {
        if (availables <= 2) {
            return 1;
        }

        int result = 0;

        // 맨 꼭대기는 1 부터 셋팅
        for (int i = 1; i <= availables; i++) {
            result++;
            availables -= i;
        }

        return result;
    }

}
