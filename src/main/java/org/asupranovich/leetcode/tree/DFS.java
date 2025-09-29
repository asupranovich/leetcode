package org.asupranovich.leetcode.tree;

import com.sun.source.tree.Tree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFS {

    public static void main(String[] args) {
        final DFS traversing = new DFS();
        TreeNode tree = new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(5,
                    new TreeNode(6),
                    new TreeNode(7))),
            new TreeNode(3,
                null,
                new TreeNode(8,
                    new TreeNode(9),
                    null)));
        System.out.println(traversing.postOrderTraversalStack(tree));
    }

    public List<Integer> inOrderTraversal(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<Integer> values = new ArrayList<>();
        values.addAll(inOrderTraversal(node.left));
        values.add(node.val);
        values.addAll(inOrderTraversal(node.right));
        return values;
    }

    public List<Integer> inOrderTraversalStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }

        return result;
    }

    public List<Integer> preOrderTraversal(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<Integer> values = new ArrayList<>();
        values.add(node.val);
        values.addAll(preOrderTraversal(node.left));
        values.addAll(preOrderTraversal(node.right));
        return values;
    }

    public List<Integer> preOrderTraversalStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            var node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    public List<Integer> postOrderTraversal(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<Integer> values = new ArrayList<>();
        values.addAll(postOrderTraversal(node.left));
        values.addAll(postOrderTraversal(node.right));
        values.add(node.val);
        return values;
    }

    public List<Integer> postOrderTraversalStack(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        LinkedList<Integer> values = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            values.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return values;
    }
}