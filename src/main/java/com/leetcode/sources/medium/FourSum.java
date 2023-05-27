package com.leetcode.sources.medium;

import java.util.*;
import java.util.stream.Collectors;

public class FourSum {

    public static void main(String[] args) {

        System.out.println(fourSum(new int[] {1,0,-1,0,-2,2}, 0));

    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        long[] longNums = Arrays.stream(nums)
                .mapToLong(num -> (long) num)
                .toArray();
        Arrays.sort(longNums);
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int a = 0; a <= longNums.length - 4; a++) {
            for (int b = a + 1; b <= longNums.length - 3; b++) {
                int c = b + 1;
                int d = longNums.length - 1;

                while (c < d) {
                    long sum = longNums[a] + longNums[b] + longNums[c] + longNums[d];
                    if (sum < target) {
                        c++;
                    } else if (sum > target) {
                        d--;
                    } else {
                        result.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                    }
                }
            }
        }

        return result.stream().toList();
    }

}
