package com.leetcode.sources.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }

    private static String longestPalindrome(String s) {
        /*
        babad: bab or aba
        cbbd: bb
         */
        return getPalindrome(s, s.length());
    }

    private static String getPalindrome(String s, int length) {
        int startIndex = 0;
        int endIndex = startIndex + length - 1;

        while (endIndex < s.length()) {
            boolean equal = true;
            int midIndex = (endIndex + startIndex) / 2;

            for (int i = startIndex; i <= midIndex; i++) {
                int reversedIndex = endIndex - (i - startIndex);
                if (s.charAt(reversedIndex) != s.charAt(i)) {
                    equal = false;
                    break;
                }
            }

            if (equal) {
                return s.substring(startIndex, endIndex + 1);
            } else {
                startIndex++;
                endIndex++;
            }
        }

        return getPalindrome(s, length - 1);
    }

}
