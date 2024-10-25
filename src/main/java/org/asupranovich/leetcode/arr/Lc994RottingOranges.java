package org.asupranovich.leetcode.arr;

import java.util.ArrayList;
import java.util.List;

public class Lc994RottingOranges {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.orangesRotting(new int[][]{
            {1},
            {1},
            {1},
            {1}
        }));
    }

    static class Solution {

        public int orangesRotting(int[][] grid) {
            List<int[]> rotten = new ArrayList<>();
            int freshCount = countFresh(grid, rotten);
            if (freshCount == 0) {
                return 0;
            }
            if (rotten.size() == 0) {
                return -1;
            }

            int minutes = 0;
            while (freshCount > 0) {
                rotten = rotAll(grid, rotten);
                if (rotten.size() == 0) {
                    return -1;
                }
                freshCount -= rotten.size();
                minutes++;
            }

            return minutes;
        }

        private List<int[]> rotAll(int[][] grid, List<int[]> rotten) {
            List<int[]> newRotten = new ArrayList<>();
            for (int[] current : rotten) {
                newRotten.addAll(rotOne(grid, current[0], current[1]));
            }
            return newRotten;
        }

        private List<int[]> rotOne(int[][] grid, int row, int col) {
            List<int[]> newRotten = new ArrayList<>();
            if (isFresh(grid, row + 1, col)) {
                grid[row + 1][col] = 2;
                newRotten.add(new int[]{row + 1, col});
            }
            if (isFresh(grid, row - 1, col)) {
                grid[row - 1][col] = 2;
                newRotten.add(new int[]{row - 1, col});
            }
            if (isFresh(grid, row, col + 1)) {
                grid[row][col + 1] = 2;
                newRotten.add(new int[]{row, col + 1});
            }
            if (isFresh(grid, row, col - 1)) {
                grid[row][col - 1] = 2;
                newRotten.add(new int[]{row, col - 1});
            }

            return newRotten;
        }

        private int countFresh(int[][] grid, List<int[]> rotten) {
            int count = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    int current = grid[row][col];
                    if (current == 1) {
                        count++;
                    } else if (current == 2) {
                        rotten.add(new int[]{row, col});
                    }
                }
            }
            return count;
        }

        private boolean isFresh(int[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                return false;
            }
            return grid[row][col] == 1;
        }
    }
}
