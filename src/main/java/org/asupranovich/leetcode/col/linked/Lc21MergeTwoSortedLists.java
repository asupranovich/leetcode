package org.asupranovich.leetcode.col.linked;

public class Lc21MergeTwoSortedLists {

    class Solution {

        public ListNode mergeTwoLists(ListNode node1, ListNode node2) {

            if (node1 == null && node2 == null) {
                return null;
            }

            ListNode head = new ListNode();
            ListNode current = head;

            while (node1 != null || node2 != null) {
                if (node1 == null) {
                    current.val = node2.val;
                    node2 = node2.next;
                } else if (node2 == null) {
                    current.val = node1.val;
                    node1 = node1.next;
                } else {
                    var val1 = node1.val;
                    var val2 = node2.val;
                    if (val1 > val2) {
                        current.val = val2;
                        node2 = node2.next;
                    } else {
                        current.val = val1;
                        node1 = node1.next;
                    }
                }
                if (node1 != null || node2 != null) {
                    current.next = new ListNode();
                    current = current.next;
                }
            }

            return head;
        }
    }

}
