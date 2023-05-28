package com.leetcode.sources.medium;

import java.util.LinkedList;
import java.util.List;

public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {

    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;

        List<ListNode> linkedList = new LinkedList<>();
        linkedList.add(node);

        while (node.next != null) {
            node = node.next;
            linkedList.add(node);
        }

        if (linkedList.size() == 1 && n == 1) {
            return null;
        }

        int deleteTargetIndex = linkedList.size() - n;

        if (deleteTargetIndex > 0) {
            linkedList.get(deleteTargetIndex - 1).next = linkedList.get(deleteTargetIndex).next;
        } else {
            linkedList.remove(0);
        }

        return linkedList.get(0);
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
