package com.leetcode.sources.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsofaPhoneNumber {

    public static void main(String[] args) {
        List<String> letterCombinations = letterCombinations("2347");
        System.out.println(letterCombinations);
    }

    private static List<String> letterCombinations(String digits) {
        /*
        abcd
        efg
        hijk

        total = 4 * 3 * 4 = 48
        aaaaaaaaaaaa bbbbbbbbbbbb cccccccccccc dddddddddddd  ws: 12, wc: 4,   ws = total / nums[0].length, wc: total / ws
        eeeeffffgggg eeeeffffgggg eeeeffffgggg eeeeffffgggg  ws: 4, wc: 12,   ws = total / (nums[0].length * nums[1].length == 4 * 3 == 12), wc: total / ws
        hijkhijkhijk hijkhijkhijk hijkhijkhijk hijkhijkhijk  ws: 1, wc: 48,   ws = total / (nums[0].length * nums[1].length * nums[2].length == 4 * 3 * 4 == 48), wc: total / ws


         */

        Queue<String> ans = new LinkedList<>();
        if(digits.isEmpty()) return Collections.emptyList();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        ans.add("");

        int cycle = 0;

        for (int digit : digits.toCharArray()) {
            int num = digit - '0';

            System.out.println(mapping[num]);

            while (!ans.isEmpty() && ans.peek().length() == cycle) {
                String poll = ans.poll();
                for (String alphabet : mapping[num].split("")) {
                    StringBuilder appended = new StringBuilder(poll).append(alphabet);
                    ans.add(appended.toString());
                }
            }

            cycle++;
        }

        return new ArrayList<>(ans);
    }
}
