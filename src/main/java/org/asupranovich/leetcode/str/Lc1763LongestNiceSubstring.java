package org.asupranovich.leetcode.str;

public class Lc1763LongestNiceSubstring {
    class Solution {
        public String longestNiceSubstring(String s) {
            if (s.length() < 2) {
                return "";
            }
            Integer[] lowerCase = new Integer[26];
            Integer[] upperCase = new Integer[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isUpperCase(c)) {
                    upperCase[c - 'A'] = i;
                } else {
                    lowerCase[c - 'a'] = i;
                }
            }

            int noPairIndex = -1;
            for (int i = 0; i < 26; i++) {
                Integer lcIndex = lowerCase[i];
                Integer ucIndex = upperCase[i];
                if (lcIndex == null && ucIndex != null) {
                    noPairIndex = ucIndex;
                    break;
                }

                if (lcIndex != null && ucIndex == null) {
                    noPairIndex = lcIndex;
                    break;
                }
            }
            if (noPairIndex < 0) {
                return s;
            }

            String subString1 = longestNiceSubstring(s.substring(0, noPairIndex));
            String subString2 = longestNiceSubstring(s.substring(noPairIndex + 1));

            if (subString1.length() >= subString2.length()) {
                return subString1;
            }
            return subString2;
        }
    }
}
