package org.asupranovich.leetcode.tree;

public class Lc104BinaryTreeMaxDepth {

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

}
