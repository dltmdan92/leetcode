package com.leetcode.sources.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame2 {

    public static void main(String[] args) {
        int[] nums = {
                5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0
        };

        Set<Integer> possibleIndices = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + i >= nums.length - 1 && i != nums.length - 1) {
                possibleIndices.add(i);
            }
        }

        int jump = jump(nums, 0, 0, possibleIndices);

        System.out.println(jump + 1);

    }

    private static int jump(int[] nums, int startIndex, int jumpCount, Set<Integer> possibleIndices) {

        if (possibleIndices.contains(startIndex)) {
            return jumpCount;
        }

        int num = nums[startIndex];
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= num; i++) {
            if (startIndex + i > nums.length - 1) {
                continue;
            }
            if (nums[startIndex + i] == 0) {
                continue;
            }

            int jump = jump(nums, startIndex + i, jumpCount + 1, possibleIndices);

            result = Math.min(result, jump);
        }

        return result;
    }

}
