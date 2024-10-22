package org.asupranovich.leetcode.str;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lc3LongestSubstringWoRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int longest = 0;
        final char[] chars = s.toCharArray();

        Map<Character, Integer> charPosMap = new LinkedHashMap<>();
        int index = 0;

        while (index < chars.length) {
            char current = chars[index];
            if (charPosMap.containsKey(current)) {
                longest = Math.max(longest, charPosMap.size());
                var iterator = charPosMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    if (current == iterator.next().getKey()) {
                        iterator.remove();
                        break;
                    }
                    iterator.remove();
                }
            }

            charPosMap.put(chars[index], index);
            index++;
        }

        return Math.max(longest, charPosMap.size());
    }

}
