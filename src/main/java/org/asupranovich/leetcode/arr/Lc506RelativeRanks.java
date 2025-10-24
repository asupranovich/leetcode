package org.asupranovich.leetcode.arr;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Lc506RelativeRanks {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findRelativeRanks(new int[] {3, 5, 6, 1, 9, 20})));
    }

    static class Solution {
        public String[] findRelativeRanks(int[] scores) {
            TreeSet<Rank> sortedRanks = new TreeSet<>(Comparator.comparingInt(Rank::score).reversed());
            for (int i = 0; i < scores.length; i++) {
                sortedRanks.add(new Rank(i, scores[i]));
            }

            String[] result = new String[scores.length];
            int index = 0;
            for (Rank rank : sortedRanks) {
                result[rank.index()] = getRank(index++);
            }
            return result;
        }

        private String getRank(int index) {
            return switch (index) {
                case 0 -> "Gold Medal";
                case 1 -> "Silver Medal";
                case 2 -> "Bronze Medal";
                default -> "" + (index + 1);
            };
        }

        record Rank(int index, int score) {}
    }

}
