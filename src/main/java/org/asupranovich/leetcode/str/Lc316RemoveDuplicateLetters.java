package org.asupranovich.leetcode.str;

import java.util.HashMap;
import java.util.Map;

public class Lc316RemoveDuplicateLetters {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters(""));
    }

    static class Solution {
        public String removeDuplicateLetters(String s) {
            Map<Character, Integer> charMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                charMap.merge(c, 1, Integer::sum);
            }

            String result = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (charMap.get(c) == 1) { // no duplicate
                    result = result + c;
                } else if (charMap.get(c) > 1) {
                    boolean shouldAdd = true;
                    Map<Character, Integer> tempMap = new HashMap<>();
                    for (int j = i + 1; j < s.length(); j++) {
                        char c2 = s.charAt(j);
                        if (charMap.get(c2) <= 0) {
                            continue;
                        }

                        tempMap.merge(c2, 1, Integer::sum);

                        if (charMap.get(c2) == 1 || charMap.get(c2).equals(tempMap.get(c2))) {
                            shouldAdd = c < c2;
                            break;
                        }
                        if (c > c2) {
                            shouldAdd = false;
                            break;
                        }
                    }

                    if (shouldAdd) {
                        result = result + c;
                        charMap.put(c, 0);
                    } else {
                        charMap.put(c, charMap.get(c) - 1);
                    }
                }
            }

            return result;
        }
    }

}
