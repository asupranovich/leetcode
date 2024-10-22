package org.asupranovich.leetcode.str;

public class Lc409LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int[] charArr = new int[58];
        final char[] chars = s.toCharArray();
        for (char c : chars) {
            int index = c - 'A';
            charArr[index] = charArr[index] + 1;
        }
        boolean addOne = false;
        int pLength = 0;

        for (int i : charArr) {
            if (i % 2 == 0) {
                pLength += i;
            } else {
                addOne = true;
                pLength += i - 1;
            }
        }

        if (addOne) {
            pLength++;
        }

        return pLength;
    }

}
