package org.asupranovich.leetcode.str;

import java.util.Set;

public class Lc345ReverseVowels {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels("hello algorithms"));
    }

    static class Solution {

        private static final Set<Character> VOWELS = Set.of('a', 'e', 'u', 'i', 'o', 'A', 'E', 'U', 'I', 'O');

        public String reverseVowels(String s) {

            char[] chars = s.toCharArray();

            int left = 0;
            int right = chars.length - 1;

            while (left < right) {
                boolean isLeftVowel = isVowel(chars[left]);
                boolean isRightVowel = isVowel(chars[right]);
                if (isLeftVowel && isRightVowel) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                    right--;
                } else {
                    if (!isLeftVowel) {
                        left++;
                    }
                    if (!isRightVowel) {
                        right--;
                    }
                }
            }

            return String.valueOf(chars);
        }

        private boolean isVowel(char c) {
            return VOWELS.contains(c);
        }
    }

}
