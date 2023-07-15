package com.leetcode.sources.programmers;

import java.util.*;

public class Test20230715_3 {

    public static void main(String[] args) {
        System.out.println(
                solution(new int[][]
                        {{1, 2}, {3, 4}, {5, 6}, {-1, 7}, {8, 9}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}}
                )
        );
    }

    private static long solution(int[][] parking) {
        Map<Integer, Set<Integer>> childrenMap = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();

        for (int node = 0; node < parking.length; node++) {
            int leftChildNode = parking[node][0];
            int rightChildNode = parking[node][1];

            if (leftChildNode == -1 && rightChildNode == -1) {
                childrenMap.put(node, Collections.emptySet());
            } else if (leftChildNode == -1 && rightChildNode == 1) {
                childrenMap.put(node, Set.of(rightChildNode));
            } else if (leftChildNode == 1 && rightChildNode == -1) {
                childrenMap.put(node, Set.of(leftChildNode));
            } else {
                childrenMap.put(node, Set.of(leftChildNode, rightChildNode));
            }

            if (leftChildNode != - 1) parentMap.put(leftChildNode, node);
            if (rightChildNode != -1) parentMap.put(rightChildNode, node);
        }

        System.out.println("CHILDREN MAP");
        childrenMap.forEach((key, value) -> {
            System.out.println("node : " + key);
            System.out.println(value);
        });

        System.out.println("PARENT MAP");
        parentMap.forEach((key, value) -> {
            System.out.println("node : " + key);
            System.out.println(value);
        });

        Map<Integer, Set<Integer>> parentNodes = new HashMap<>();

        for (int i = 0; i < parking.length; i++) {
            parentNodes.put(i, new HashSet<>());
            int parentNodeHolder = i;
            while (parentNodeHolder > 0) {
                parentNodeHolder = parentMap.get(parentNodeHolder);
                parentNodes.get(i).add(parentNodeHolder);
            }
        }



        System.out.println("---------------------");

        Set<Integer>[] result = new HashSet[parking.length];

        result[0] = new HashSet<>();

        for (int parkNode1 = 1; parkNode1 < parking.length; parkNode1++) {
            System.out.println();
            System.out.println();
            System.out.println("parkNode1 : " + parkNode1);

            Set<Integer> childNodes = new HashSet<>();
            result[parkNode1] = new HashSet<>();

            System.out.println("parentNodes : " + parentNodes);

            for (int i = 0; i < parking.length; i++) {

                if (parentNodes.containsKey(i) || i == parkNode1 || parentNodes.get(i).contains(parkNode1)) {

                } else {
                    System.out.printf("i : %d \t", i);
                    result[parkNode1].add(i);
                }
            }

            System.out.println();
            System.out.println();
        }

        int answer = 0;

        for (Set<Integer> x : result) {
            System.out.println(x);
            answer += x.size();
        }

        return answer;
    }

}
