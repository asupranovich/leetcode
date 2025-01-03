package org.asupranovich.leetcode.col.linked;

public class Lc206ReverseLinkedList {

    public ListNode reverseList(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode reversed = new ListNode();
        reverse(node, reversed);
        return reversed;
    }

    private ListNode reverse(ListNode node, ListNode newRoot) {
        if (node.next == null) {
            newRoot.val = node.val;
            return newRoot;
        }

        ListNode reversedNode = reverse(node.next, newRoot);
        reversedNode.next = new ListNode(node.val);
        return reversedNode.next;
    }

    public ListNode reverseList2(ListNode node) {
        ListNode first = null;
        ListNode second = node;

        while (second != null) {
            ListNode third = second.next;
            second.next = first;
            first = second;
            second = third;
        }

        return first;
    }
}
