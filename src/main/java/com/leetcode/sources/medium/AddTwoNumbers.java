package com.leetcode.sources.medium;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        [9,9,9,9,9,9,9]
        [9,9,9,9]

        [18,18,18,18,9,9,9]
        [8,9,9,9,0,0,0,1]
         */
        List<Integer> sumList = new ArrayList<>();
        sumList.add(l1.val + l2.val);
        l1 = l1.next;
        l2 = l2.next;

        while ((l1 != null) || (l2 != null)) {
            Integer l1Val = getVal(l1);
            Integer l2Val = getVal(l2);

            sumList.add(l1Val + l2Val);

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        boolean tossOne = false;

        ListNode firstNode = new ListNode(0);
        ListNode node = firstNode;

        for (int i = 0; i < sumList.size(); i++) {
            Integer sumVal = sumList.get(i) + (tossOne ? 1 : 0);
            int val = 0;
            if (sumVal > 9) {
                tossOne = true;
                val = sumVal % 10;
            } else {
                tossOne = false;
                val = sumVal;
            }
            node.next = new ListNode(val);
            node = node.next;
        }
        if (tossOne) {
            node.next = new ListNode(1);
        }

        return firstNode.next;
    }

    private static Integer getVal(ListNode l1) {
        if (l1 != null)
            return l1.val;
        return 0;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
