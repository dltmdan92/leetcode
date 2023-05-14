package com.leetcode.sources.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSumToZero {

    public static void main(String[] args) {

        System.out.println(threeSum(new int[] {0,0,0}));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        /*
        -1,0,1,2,-1,-4
        -4, -1, -1, 0, 1, 2
         */

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++; right--;

                } else if (0 < sum) {
                    right--;
                } else {
                    left++;
                }

            }

        }

        return new ArrayList<>(result);
    }

}
