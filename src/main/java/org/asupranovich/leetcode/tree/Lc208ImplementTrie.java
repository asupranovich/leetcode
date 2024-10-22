package org.asupranovich.leetcode.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc208ImplementTrie {

    static class Trie {
        private final Set<String> words;
        private final Node root;

        public Trie() {
            this.words = new HashSet<>(1000);
            this.root = new Node('\u0000');
        }

        public void insert(String word) {
            words.add(word);

            Node node = root;
            for (char ch : word.toCharArray()) {
                Node child = node.children.get(ch);
                if (child == null) {
                    child = new Node(ch);
                    node.children.put(ch, child);
                }
                node = child;
            }
        }

        public boolean search(String word) {
            return words.contains(word);
        }

        public boolean startsWith(String prefix) {
            String str = "";
            Node node = root;
            for (char ch : prefix.toCharArray()) {
                str += ch;
                node = node.children.get(ch);
                if (node == null) {
                    return false;
                }
                if (prefix.equals(str)) {
                    return true;
                }
            }

            return false;
        }
    }

    static class Node {
        Character ch;
        Map<Character, Node> children;

        Node(char ch) {
            this.ch = ch;
            this.children = new HashMap<>();
        }
    }

}
