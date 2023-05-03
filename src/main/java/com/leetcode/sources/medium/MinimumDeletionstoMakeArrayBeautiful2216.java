package com.leetcode.sources.medium;

public class MinimumDeletionstoMakeArrayBeautiful2216 {

    public static void main(String[] args) {
        System.out.println(minDeletion(new int[] {1,1,2,2,3,3}));
    }

    public static int minDeletion(int[] nums) {
        int deleteCount = 0;
        int i = 0;

        while (i <= nums.length - 1) {
            int comparePlusIndex = 1;

            while (i + comparePlusIndex < nums.length && nums[i] == nums[i + comparePlusIndex]) {
                deleteCount++;
                comparePlusIndex++;
            }
            i += comparePlusIndex + 1;
        }
        if ((nums.length - deleteCount) % 2 != 0) {
            deleteCount++;
        }
        return deleteCount;
    }

}
