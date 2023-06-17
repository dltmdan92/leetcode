package com.leetcode.sources.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesinPairs {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode node = swapPairs(listNode);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        boolean even = false;

        ListNode node = head;
        ListNode first = null;
        ListNode tail = null;

        Queue<Integer> leftList = new LinkedList<>();
        Queue<Integer> rightList = new LinkedList<>();

        while (node != null) {
            if (!even) {
                leftList.add(node.val);
                node = node.next;
                even = true;
            } else {
                rightList.add(node.val);
                node = node.next;
                even = false;
            }
        }

        while (!leftList.isEmpty()) {
            Integer left = leftList.poll();

            if (!rightList.isEmpty()) {
                ListNode right = new ListNode(rightList.poll());
                if (first == null) {
                    first = right;
                    tail = first;
                } else {
                    tail.next = right;
                    tail = tail.next;
                }
            }

            ListNode leftNode = new ListNode(left);

            tail.next = leftNode;
            tail = tail.next;
        }

        return first;
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
