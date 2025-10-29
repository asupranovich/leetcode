package org.asupranovich.leetcode.str;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc819MostCommonWord {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }

    static class Solution {

        private static final Set<Character> DELIMITERS = Set.of(' ', ',', '.', '?', '!', '\'', ':', ';');

        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));

            Map<String, Integer> wordMap = new HashMap<>();
            StringBuilder wordBuilder = new StringBuilder();
            for (int i = 0; i < paragraph.length(); i++) {
                char c = paragraph.charAt(i);
                if (DELIMITERS.contains(c)) {
                    String word = wordBuilder.toString();
                    wordBuilder = new StringBuilder();
                    if (word.isEmpty() || bannedWords.contains(word)) {
                        continue;
                    }
                    wordMap.merge(word, 1, Integer::sum);
                } else {
                    wordBuilder.append(Character.toLowerCase(c));
                }
            }

            if (!wordBuilder.isEmpty()) {
                String word = wordBuilder.toString();
                wordMap.merge(word, 1, Integer::sum);
            }

            String result = null;
            int maxCount = 0;
            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                if (entry.getValue() > maxCount) {
                    result = entry.getKey();
                    maxCount = entry.getValue();
                }
            }

            return result;
        }
    }

}
