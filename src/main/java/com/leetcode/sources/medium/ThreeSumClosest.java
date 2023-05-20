package com.leetcode.sources.medium;

import java.util.*;

public class ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {1,1,1,0}, -100));
    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;

        for (int left = 0; left < nums.length - 2; left++) {
            for (int mid = left + 1, right = nums.length - 1; mid < right;) {

                int sum = nums[left] + nums[mid] + nums[right];

                if (sum == target) {
                    return sum;
                }

                int currentDiff = Math.abs(target - sum);

                if (minDiff > currentDiff) {
                    System.out.format("minDiff : %d, currentDiff : %d, sum: %d", minDiff, currentDiff, sum);
                    System.out.println();
                    minDiff = currentDiff;
                    minSum = sum;
                }


                if (sum > target) {
                    right--;
                } else {
                    mid++;
                }


            }
        }

        return minSum;
    }

}
