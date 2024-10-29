package org.asupranovich.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class TreeNode {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.fromArray(new Integer[]{3, 9, 20, null, null, 15, 7, 21, 22, null, 23});
        System.out.println(treeNode);
    }

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        List<List<Integer>> levels = new ArrayList<>();
        List<TreeNode> levelNodes = List.of(this);
        while (true) {
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            List<Integer> levelValues = new ArrayList<>();
            for (TreeNode node : levelNodes) {
                if (node == null) {
                    levelValues.add(null);
                    nextLevelNodes.add(null);
                    nextLevelNodes.add(null);
                } else {
                    levelValues.add(node.val);
                    nextLevelNodes.add(node.left);
                    nextLevelNodes.add(node.right);
                }
            }
            levels.add(levelValues);
            if (nextLevelNodes.stream().noneMatch(Objects::nonNull)) {
                break;
            }
            levelNodes = nextLevelNodes;
        }

        return levels.stream().map(Object::toString).collect(Collectors.joining("\n"));
    }

    public static TreeNode fromArray(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cursor = 1;
        while (cursor < values.length) {
            TreeNode node = queue.poll();
            int leftValueIndex = cursor++;
            Integer leftValue = leftValueIndex < values.length ? values[leftValueIndex] : null;
            if (leftValue != null) {
                TreeNode left = new TreeNode(leftValue);
                node.left = left;
                queue.add(left);
            }

            int rightValueIndex = cursor++;
            Integer rightValue = rightValueIndex < values.length ? values[rightValueIndex] : null;
            if (rightValue != null) {
                TreeNode right = new TreeNode(rightValue);
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
