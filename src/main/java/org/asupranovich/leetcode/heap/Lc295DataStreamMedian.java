package org.asupranovich.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc295DataStreamMedian {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.insertNum(1);
        solution.insertNum(2);
        solution.insertNum(3);
        solution.insertNum(4);
        System.out.println(solution.findMedian());
    }

    static class Solution {

        private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public void insertNum(int num) {
            if (maxHeap.isEmpty()) {
                maxHeap.offer(num);
            } else {
                if (num < maxHeap.peek()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }
                // re-balance
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.offer(maxHeap.poll());
                } else if (minHeap.size() > maxHeap.size() + 1) {
                    maxHeap.offer(minHeap.poll());
                }
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            }
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

}
