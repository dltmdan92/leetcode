package com.leetcode.sources.medium;

public class SearchinRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[] {1,3}, 1));
    }

    private static int search(int[] nums, int target) {
        int lastIndex = nums.length - 1;

        int beforeIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                beforeIndex = i;
                break;
            }
        }

        System.out.printf("beforeIndex : %d\n",beforeIndex);

        if (beforeIndex == -1) {
            return -1;
        }

        int newIndex = beforeIndex + target;
        System.out.printf("newIndex : %d\n", newIndex);
        if (newIndex <= lastIndex) {
            return newIndex;
        }
        return newIndex - lastIndex - 1;
    }
}
