package org.asupranovich.leetcode.arr;

public class Lc844BackspaceStringCompare {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("nzp#o#g", "b#nzp#o#g"));
    }

    static class Solution {
        private static final char BACKSPACE = '#';

        public boolean backspaceCompare(String s, String t) {
            int si = s.length();
            int ti = t.length();

            while (si >=0 && ti >= 0) {
                si = shift(s, si);
                ti = shift(t, ti);
                if (si >= 0 && ti >= 0 && s.charAt(si) != t.charAt(ti)) {
                    return false;
                }
            }

            return si == ti;
        }

        private int shift(String s, int i) {
            int backspaces = 1;
            while (backspaces > 0 && i >= 0) {
                i--;
                if (i < 0 || s.charAt(i) != BACKSPACE) {
                    backspaces--;
                } else {
                    backspaces++;
                }
            }
            return i;
        }
    }

}
