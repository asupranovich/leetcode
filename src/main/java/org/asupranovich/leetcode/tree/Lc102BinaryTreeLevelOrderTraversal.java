package org.asupranovich.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lc102BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> levelNodes = List.of(root);
        while (!levelNodes.isEmpty()) {
            result.add(levelNodes.stream().map(node -> node.val).toList());
            levelNodes = levelNodes.stream()
                .map(node -> Arrays.asList(node.left, node.right))
                .flatMap(List::stream)
                .filter(Objects::nonNull).toList();
        }

        return result;
    }

}
