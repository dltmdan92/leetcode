package com.leetcode.sources.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * O(log n) 으로 풀어야 한다.
 */
public class FindFirstandLastPositionofElementinSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[] {2,2}, 2)));
    }

    private static int[] searchRange(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private static int[] binarySearch(int[] nums, int target, int start, int end) {
        System.out.printf("start: %d, end: %d\n", start, end);
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        int mid = (start + end) / 2;

        if (start == end && nums[mid] != target || start > end) {
            return new int[] {-1, -1};
        }

        if (start == end && nums[mid] == target) {
            return new int[] {mid, mid};
        }

        if (nums[mid] == target) {
            int leftIndex = mid;
            int rightIndex = mid;

            while (leftIndex >= 0) {
                if (leftIndex == 0) {
                    break;
                }
                if (nums[leftIndex - 1] == target) {
                    leftIndex--;
                } else {
                    break;
                }
            }
            while (rightIndex < nums.length) {
                if (rightIndex == nums.length - 1) {
                    break;
                }
                if (nums[rightIndex + 1] == target) {
                    rightIndex++;
                } else {
                    break;
                }
            }
            return new int[] {leftIndex, rightIndex};
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, start, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, end);
        }
    }

}
