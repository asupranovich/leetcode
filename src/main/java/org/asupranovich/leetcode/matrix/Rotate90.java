package org.asupranovich.leetcode.matrix;

import java.util.Arrays;

public class Rotate90 {

    public static void main(String[] args) {
        var source = new int[][]{
            {1, 1, 1, 1},
            {2, 2, 2, 2},
            {3, 3, 3, 3},
            {4, 4, 4, 4},
            {5, 5, 5, 5},
        };
        Solution solution = new Solution();
        int[][] rotated = solution.rotate(source);
        for (int[] row : rotated) {
            System.out.println(Arrays.toString(row));
        }
    }

    static class Solution {

        public int[][] rotate(int[][] source) {
            int[][] result = new int[source.length][source[0].length];
            for (int i = 0; i < source.length; i++) {
                int[] row = source[i];
                for (int j = 0; j < row.length; j++) {
                    result[Math.abs(i - source.length + 1)][j] = source[i][j];
                }
            }
            return result;
        }

    }

}
