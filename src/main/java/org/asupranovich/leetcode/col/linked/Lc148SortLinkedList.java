package org.asupranovich.leetcode.col.linked;

public class Lc148SortLinkedList {

    class Solution {
        public ListNode sortList(ListNode node) {
            if (node == null || node.next == null) {
                return node;
            }

            ListNode second = getSecondHalf(node);

            ListNode firstSorted = sortList(node);
            ListNode secondSorted = sortList(second);

            return merge(firstSorted, secondSorted);
        }

        private ListNode getSecondHalf(ListNode node) {
            if (node.next == null) {
                return null;
            }
            ListNode slow = node;
            ListNode fast = node.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode secondHalf = slow.next;
            slow.next = null;

            return secondHalf;
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0), tail = dummy;
            while (l1 != null && l2 != null) {
                // Compare values from each list and append the smaller one
                if (l1.val < l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }
            // Append any remaining nodes from either list
            tail.next = (l1 != null) ? l1 : l2;
            return dummy.next; // Return the head of the merged list
        }
    }

}
