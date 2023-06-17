package com.leetcode.sources.codility;

public class NodeEdge {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[] {1,2,4,4,3}, new int[] {2,3,1,3,1}));
    }

    private static boolean solution(int N, int[] A, int[] B) {
        boolean[] edges = new boolean[N + 1]; // 0 1 ... N

        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];

            if (a + 1 == b) {
                edges[a] = true;
            } else if (a == b + 1) {
                edges[b] = true;
            }
        }

        for (int i = 1; i < edges.length - 1; i++) {
            boolean edge = edges[i];
            if (!edge) return false;
        }

        return true;
    }
}
