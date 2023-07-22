package com.leetcode.sources.programmers;

import java.util.*;
import java.util.stream.Collectors;

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
            Set<Integer> children = new HashSet<>();

            if (parking[node][0] != -1) {
                children.add(parking[node][0]);
                parentMap.put(parking[node][0], node);
            }

            if (parking[node][1] != -1) {
                children.add(parking[node][1]);
                parentMap.put(parking[node][1], node);
            }

            childrenMap.put(node, children);
        }

        long result = 0;

        for (int node = 0; node < parking.length; node++) {
            System.out.printf("node : %d, children count : %d, parent count : %d\n", node, getChildrenCount(node, childrenMap), getParentsCount(node, parentMap));

            long exclusiveCount = 1 + getChildrenCount(node, childrenMap) + getParentsCount(node, parentMap);
            result += parking.length - exclusiveCount;
        }

        return result / 2;
    }

    private static long getChildrenCount(int node, Map<Integer, Set<Integer>> childrenMap) {
        long result = 0;
        Set<Integer> children = childrenMap.get(node);

        while (!children.isEmpty()) {
            result += children.size();
            children = children.stream()
                    .map(childrenMap::get)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toSet());
        }

        return result;
    }

    private static long getParentsCount(int node, Map<Integer, Integer> parentsMap) {
        Integer parent = parentsMap.get(node);
        long result = 0;

        while (parent != null) {
            result++;
            parent = parentsMap.get(parent);
        }

        return result;
    }

}
