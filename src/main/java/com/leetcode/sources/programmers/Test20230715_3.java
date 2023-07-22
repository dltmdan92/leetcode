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

        Map<Integer, Integer> childrenCountMap = new HashMap<>();
        for (int node = parking.length - 1; node >= 0; node--) {
            Set<Integer> children = childrenMap.get(node);

            Integer childrenCountOfChildren = children.stream()
                    .filter(childrenCountMap::containsKey)
                    .map(childrenCountMap::get)
                    .reduce(Integer::sum)
                    .orElse(0);

            childrenCountMap.put(node, children.size() + childrenCountOfChildren);

            System.out.printf("node : %d, children count : %d\n", node, childrenCountMap.get(node));
        }

        Map<Integer, Integer> parentCountMap = new HashMap<>();
        for (int node = 0; node < parking.length; node++) {
            if (parentMap.containsKey(node)) {
                Integer parentNode = parentMap.get(node);
                Integer parentCountOfParent = parentCountMap.getOrDefault(parentNode, 0);
                parentCountMap.put(node, 1 + parentCountOfParent);
                System.out.printf("parent node : %d, parent count of parent : %d\n", parentNode, parentCountOfParent);
            } else {
                parentCountMap.put(node, 0);
            }
        }

        for (int node = 0; node < parking.length; node++) {
            System.out.printf("node : %d, children count : %d, parent count : %d\n", node, childrenCountMap.get(node), parentCountMap.get(node));
            long exclusiveCount = 1 + childrenCountMap.get(node) + parentCountMap.get(node);
            result += parking.length - exclusiveCount;
        }

        return result / 2;
    }

}
