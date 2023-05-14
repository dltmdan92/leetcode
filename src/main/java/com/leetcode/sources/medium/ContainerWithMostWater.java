package com.leetcode.sources.medium;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {

        int result = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            int width = right - left;
            int waterHeight = Math.min(height[left], height[right]);

            result = Math.max(result, width * waterHeight);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
