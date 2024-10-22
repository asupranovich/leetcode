package org.asupranovich.leetcode.str;

import java.util.Stack;

public class Lc20ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() % 2 > 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char next : s.toCharArray()) {
            if (next == '(' || next == '{' || next == '[') {
                stack.push(next);
            } else {
                final Character prev = stack.empty() ? null : stack.peek();
                if (prev == null || (next == ')' && prev != '(') || (next == '}' && prev != '{') || (next == ']' && prev != '[')) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
