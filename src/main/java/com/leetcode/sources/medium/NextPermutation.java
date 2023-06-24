package com.leetcode.sources.medium;

import java.util.*;

public class NextPermutation {

    public static void main(String[] args) {
        nextPermutation(new int[]{1,3,2});
    }

    private static void nextPermutation(int[] nums) {
        /*
        123
        - 123, 132, 213, 231, 312, 321

        321
        -

        115
        - 115, 151, 511


         */

        if (nums.length == 1) {
            System.out.println(Arrays.toString(nums));
        }
        if (nums.length == 2) {
            System.out.println(Arrays.toString(new int[]{nums[1], nums[0]}));
        }

        int x = nums.length - 2;
        int y = nums.length - 1;

        int sum = 0;
        int nextSum = 0;

        for (int i = 0; i <= nums.length - 3; i++) {
            sum += nums[i] * Math.pow(10, nums.length - 1 - i);
            System.out.println("sum : " + sum);
            nextSum += nums[i] * Math.pow(10, nums.length - 1 - i);
            System.out.println("nextSum : " + nextSum);
        }

        sum += nums[x] * 10 + nums[y];
        nextSum += nums[y] * 10 + nums[x];

        System.out.printf("sum : %d, nextSum : %d\n", sum, nextSum);

        if (sum >= nextSum) {
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
        } else if (sum < nextSum) {
            int[] result = Arrays.stream(String.valueOf(nextSum).split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(Arrays.toString(result));
        } else {

        }
    }

}
