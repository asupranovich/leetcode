package org.asupranovich.leetcode.tree;

import java.util.Stack;

public class Lc404SumOfLeftLeaves {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumOfLeftLeaves(TreeNode.fromArray(new Integer[] {3,9,20,null,null,15,7})));
    }

    static class Solution {
        public int sumOfLeftLeaves(TreeNode node) {
            if (node == null) {
                return 0;
            }

            if (node.left != null && isLeaf(node.left)) {
                return node.left.val + sumOfLeftLeaves(node.right);
            }

            return sumOfLeftLeaves(node.left) + sumOfLeftLeaves(node.right);
        }

        private boolean isLeaf(TreeNode node) {
            return node.left == null && node.right == null;
        }
    }

}
