package com.leetcode.sources.codility;

public class IntegerReverse {
    public static void main(String[] args) {
        solution(99_999_999);
        System.out.println();
        solution(111000);
        System.out.println();
        solution(54311);
        System.out.println();
        solution(54310);
        System.out.println();
        solution(54340);
        System.out.println();
        solution(54040);
        System.out.println();
        solution(8888888);
        System.out.println();
        solution(567895);

    }

    public static void solution(int N) {

        if (N % 10 != 1) System.out.print(Integer.parseInt(String.valueOf(N).replace("0", "")) % 10);
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print != 1 && N % 10 != 0) {
                enable_print = 1;
            }
            else if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }

}
