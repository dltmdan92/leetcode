package com.leetcode.sources.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("(("));
    }

    private static boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }

        // stack
        char a = '(';
        char b = '{';
        char c = '[';
        // queue
        char d = ')';
        char e = '}';
        char f = ']';

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);

            if (charAt == a || charAt == b || charAt == c) {
                stack.push(charAt);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (charAt == d) {
                    if (stack.peek() == a) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (charAt == e) {
                    if (stack.peek() == b) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (charAt == f) {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        if (stack.size() != 0) {
            return false;
        }

        return true;
    }

}
