package org.asupranovich.leetcode.col;

import java.util.Stack;

public class Lc232QueueUsingStacks {

    private final Stack<Integer> writeStack = new Stack<>();
    private final Stack<Integer> readStack = new Stack<>();

    public void push(int x) {
        if (writeStack.empty()) {
            while (!readStack.empty()) {
                writeStack.push(readStack.pop());
            }
        }
        writeStack.push(x);
    }

    public int pop() {
        if (readStack.empty()) {
            while (!writeStack.empty()) {
                readStack.push(writeStack.pop());
            }
        }
        return readStack.pop();
    }

    public int peek() {
        if (readStack.empty()) {
            while (!writeStack.empty()) {
                readStack.push(writeStack.pop());
            }
        }
        return readStack.peek();
    }

    public boolean empty() {
        return writeStack.empty() && readStack.empty();
    }

}
