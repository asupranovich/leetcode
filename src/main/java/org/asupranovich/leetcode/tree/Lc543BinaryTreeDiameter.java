package org.asupranovich.leetcode.tree;

public class Lc543BinaryTreeDiameter {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        height(node);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

}
