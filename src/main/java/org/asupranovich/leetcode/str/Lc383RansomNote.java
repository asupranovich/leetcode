package org.asupranovich.leetcode.str;

import java.util.Arrays;

public class Lc383RansomNote {

    public boolean canConstruct(String target, String source) {
        int targetLength = target.length();
        int sourceLength = source.length();
        if (targetLength > sourceLength) {
            return false;
        }

        char[] targetChars = target.toCharArray();
        Arrays.sort(targetChars);
        char[] sourceChars = source.toCharArray();
        Arrays.sort(sourceChars);

        char pointer = 0;
        int offset = 0;
        for (int i = 0; i < targetLength; i++) {
            if (i + offset >= sourceLength) {
                return false;
            }
            char next = targetChars[i];
            if (pointer == next) {
                if (sourceChars[i + offset] != pointer) {
                    return false;
                }
            } else {
                pointer = next;
                while (sourceChars[i + offset] != pointer) {
                    offset++;
                    if (i + offset >= sourceLength || sourceChars[i + offset] > pointer) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
