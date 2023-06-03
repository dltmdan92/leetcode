package com.leetcode.sources.easy;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode start = new ListNode();
        ListNode currentNode = start;

        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    currentNode.val = list1.val;
                    list1 = list1.next;
                } else {
                    currentNode.val = list2.val;
                    list2 = list2.next;
                }
            } else if (list1 == null && list2 != null) {
                currentNode.val = list2.val;
                list2 = list2.next;
            } else if (list1 != null && list2 == null) {
                currentNode.val = list1.val;
                list1 = list1.next;
            }
            if (list1 != null || list2 != null) {
                currentNode.next = new ListNode();
                currentNode = currentNode.next;
            }
        }
        return start;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }
}
