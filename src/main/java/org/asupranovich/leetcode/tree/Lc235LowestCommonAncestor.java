package org.asupranovich.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Lc235LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        find(root, p, pPath);

        List<TreeNode> qPath = new ArrayList<>();
        find(root, q, qPath);

        TreeNode common = root;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i).equals(qPath.get(i))) {
                common = pPath.get(i);
            } else {
                break;
            }
        }

        return common;
    }

    private void find(TreeNode parent, TreeNode node, List<TreeNode> path) {
        path.add(parent);
        if (parent.val == node.val) {
            return;
        }
        if (node.val < parent.val) {
            find(parent.left, node, path);
        } else {
            find(parent.right, node, path);
        }
    }

}
