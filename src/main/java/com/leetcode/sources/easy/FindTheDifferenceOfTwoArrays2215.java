package com.leetcode.sources.easy;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/
 */
public class FindTheDifferenceOfTwoArrays2215 {

    public static void main(String[] args) {
        List<List<Integer>> answer = findDifference(
                new int[] {1, 2, 3, 3},
                new int[] {1, 1, 2, 2}
        );
        System.out.println(answer);
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = toSet(nums1);
        Set<Integer> nums2Set = toSet(nums2);

        List<Integer> nums1Result = nums1Set.stream()
                .filter(o -> !nums2Set.contains(o))
                .toList();

        List<Integer> nums2Result = nums2Set.stream()
                .filter(o -> !nums1Set.contains(o))
                .toList();

        return List.of(nums1Result, nums2Result);
    }

    private static Set<Integer> toSet(int[] nums1) {
        return Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toSet());
    }

}
