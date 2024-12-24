package org.asupranovich.leetcode.num;

import java.util.stream.IntStream;

public class Lc2384LargestPalindromicNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestPalindromic("000900100"));

        IntStream.of().min().orElse(-1);
    }

    static class Solution {
        public String largestPalindromic(String num) {
            int[] countArray = new int[10];
            for (char c : num.toCharArray()) {
                int i = c - '0';
                countArray[i] = countArray[i] + 1;
            }

            StringBuilder prefix = new StringBuilder();
            int middle = -1;
            for (int i = 9; i >= 0; i--) {
                if (i != 0 || prefix.length() > 0) {
                    int count = countArray[i];
                    if (count > 1) {
                        int half = count/2;
                        for (int j = 0; j < half; j++) {
                            prefix.append(i);
                        }
                        countArray[i] = countArray[i] - half*2;
                    }
                }
                if (middle == -1 && countArray[i] > 0) {
                    middle = i;
                }
            }

            StringBuilder suffix = new StringBuilder(prefix);

            if (middle > -1) {
                prefix.append(middle);
            }

            prefix.append(suffix.reverse());

            return prefix.toString();
        }
    }

}
