package org.asupranovich.leetcode.num;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc150ReversePolishNotation {

    Set<String> OPERATORS = new HashSet<>(List.of("+", "-", "/", "*"));

    public int evalRPN(String[] tokens) {

        List<Object> list = new ArrayList<>();
        for (String token : tokens) {
            if (OPERATORS.contains(token)) {
                list.add(token);
            } else {
                list.add(Integer.parseInt(token));
            }
        }

        return calculate(list);
    }

    private int calculate(List<Object> elements) {
        int size = elements.size();
        if (size == 1) {
            return (Integer) elements.get(0);
        }

        List<Object> truncated = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Object first = elements.get(i);
            Object second = i < size - 1 ? elements.get(i + 1) : null;
            Object third = i < size - 2 ? elements.get(i + 2) : null;
            if (first instanceof Integer a && second instanceof Integer b && third instanceof String o) {
                truncated.add(perform(a, b, o));
                i = i + 2;
            } else {
                truncated.add(first);
            }
        }
        return calculate(truncated);
    }

    private int perform(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }

}
