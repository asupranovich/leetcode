package org.asupranovich.leetcode.col;

import java.util.ArrayList;
import java.util.List;

public class Lc155MinStack {

    class MinStack {
        private final List<int[]> stack;
        private int[] last;

        public MinStack() {
            this.stack = new ArrayList<>();
        }

        public void push(int val) {
            int min = val;
            if (last != null) {
                min = Math.min(min, last[1]);
            }

            last = new int[]{val, min};
            stack.add(last);
        }

        public void pop() {
            int size = stack.size();
            if (size > 0) {
                stack.remove(--size);
            }
            last = size - 1 >= 0 ? stack.get(size - 1) : null;
        }

        public int top() {
            return last[0];
        }

        public int getMin() {
            return last[1];
        }
    }

}
