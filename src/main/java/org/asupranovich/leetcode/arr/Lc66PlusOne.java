package org.asupranovich.leetcode.arr;

import java.util.stream.IntStream;

public class Lc66PlusOne {

    public int[] plusOne(int[] digits) {

        if (IntStream.of(digits).allMatch(i -> i == 9)) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            int current = digits[i];
            if (current != 9) {
                digits[i] = current + 1;
                break;
            } else {
                digits[i] = 0;
            }
        }

        return digits;
    }

}
