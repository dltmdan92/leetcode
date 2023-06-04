package com.leetcode.sources.easy;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(
                new int[] {2,5,5,11},
                10
        )));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexList = indexMap.getOrDefault(nums[i], new LinkedList<>());
            indexList.add(i);
            indexMap.put(nums[i], indexList);
        }

        int[] result = new int[2];

        for (int key : indexMap.keySet()) {
            int secondKey = target - key;
            if (key == secondKey) {
                if (indexMap.get(key).size() == 2) {
                    result[0] = indexMap.get(key).get(0);
                    result[1] = indexMap.get(key).get(1);
                    break;
                }
            } else if (indexMap.containsKey(secondKey)) {
                result[0] = indexMap.get(key).get(0);
                result[1] = indexMap.get(secondKey).get(0);
                break;
            }
        }
        return result;
    }

}
