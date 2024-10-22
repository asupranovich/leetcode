package org.asupranovich.leetcode.graph;

import java.util.HashMap;
import java.util.Map;

public class Lc133CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Map<Integer, Node> map = new HashMap<>();
        Map<Integer, Node> clones = new HashMap<>();
        getAllNodes(node, map, clones);

        map.forEach((k, v) -> {
            Node clone = clones.get(k);
            v.neighbors.stream().map(n -> n.val).map(clones::get).forEach(clone.neighbors::add);
        });

        return clones.get(node.val);
    }

    private void getAllNodes(Node node, Map<Integer, Node> map, Map<Integer, Node> clones) {
        if (map.containsKey(node.val)) {
            return;
        }
        map.put(node.val, node);
        clones.put(node.val, new Node(node.val));
        node.neighbors.forEach(n -> getAllNodes(n, map, clones));
    }

}
