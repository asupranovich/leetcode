package org.asupranovich.leetcode.tree;

import java.util.Stack;

public class Lc98ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode node) {
        if (node == null) {
            return true;
        }
        final Stack<Integer> stack = new Stack<>();
        return toList(node, stack);
    }

    private boolean toList(TreeNode node, Stack<Integer> list) {
        if (node == null) {
            return true;
        }
        boolean flag = toList(node.left, list);
        flag = flag && (list.isEmpty() || node.val > list.peek());
        list.push(node.val);
        flag = flag && toList(node.right, list);
        return flag;
    }

}
