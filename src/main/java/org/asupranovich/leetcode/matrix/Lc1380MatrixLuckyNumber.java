package org.asupranovich.leetcode.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc1380MatrixLuckyNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.luckyNumbers(new int[][]{
            {3, 7, 8},
            {9, 11, 13},
            {15, 16, 17}
        }));
    }

    static class Solution {

        public List<Integer> luckyNumbers(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            for (int[] ints : matrix) {
                int rowMin = ints[0];
                int column = 0;
                for (int i = 1; i < ints.length; i++) {
                    int cur = ints[i];
                    if (cur < rowMin) {
                        rowMin = cur;
                        column = i;
                    }
                }
                boolean isMax = true;
                for (int[] value : matrix) {
                    if (value[column] > rowMin) {
                        isMax = false;
                        break;
                    }
                }
                if (isMax) {
                    result.add(rowMin);
                }
            }
            return result;
        }
    }

}
