package org.asupranovich.leetcode.tree;

import java.util.Iterator;
import java.util.LinkedList;

public class Lc236LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pPath = new LinkedList<>();
        find(root, p, pPath);

        LinkedList<TreeNode> qPath = new LinkedList<>();
        find(root, q, qPath);

        TreeNode common = root;
        Iterator<TreeNode> pPathIterator = pPath.iterator();
        Iterator<TreeNode> qPathIterator = qPath.iterator();
        while (pPathIterator.hasNext() && qPathIterator.hasNext()) {
            TreeNode pPathNode = pPathIterator.next();
            TreeNode qPathNode = qPathIterator.next();
            if (pPathNode == qPathNode) {
                common = pPathNode;
            } else {
                break;
            }
        }

        return common;
    }

    private boolean find(TreeNode current, TreeNode node, LinkedList<TreeNode> path) {
        if (current == null) {
            return false;
        }

        if (current.val == node.val || find(current.left, node, path) || find(current.right, node, path)) {
            path.addFirst(current);
            return true;
        }
        return false;
    }

}
