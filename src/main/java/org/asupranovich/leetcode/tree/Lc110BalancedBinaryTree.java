package org.asupranovich.leetcode.tree;

public class Lc110BalancedBinaryTree {

    public boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.abs(leftHeight - rightHeight) < 2 && isBalanced(node.left) && isBalanced(node.right);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

}
