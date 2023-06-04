package com.leetcode.sources.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/solutions/2542620/python-java-w-explanation-faster-than-96-w-proof-easy-to-understand/
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }

    private static List<String> generateParenthesis(int n) {
        /*
        1, 2, 5, 8

        n = 1
        ["()"]
        leftcount: 0, rightcount: 0, n: 1
        leftcount: 1, rightcount: 0, n: 1
        leftcount: 1, rightcount: 1, n: 1

        n = 2
        ["(())",
        "()()"]
        leftcount: 0, rightcount: 0, n: 2


        n = 3
        ["((()))",
        "(()())","(())()","()(())",
        "()()()"]

        */

        List<String> strings = new LinkedList<>();

        recurse(strings, "", 0, 0, n);

        return strings;
    }

    private static void recurse(List<String> strings, String string, int left, int right, int n) {
        if (string.length() == n * 2) {
            strings.add(string);
        }
        if (left < n) {
            recurse(strings, string + "(", left+1, right, n);
        }
        if (left > right) {
            recurse(strings, string + ")", left, right+1, n);
        }
    }

}
