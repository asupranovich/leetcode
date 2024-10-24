package org.asupranovich.leetcode.arr;

public class Lc200NumberOfIslands {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.numIslands(new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '1'}
        }));
    }

    static class Solution {

        public int numIslands(char[][] grid) {

            int number = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == '1') {
                        number++;
                        flood(grid, row, col);
                    }
                }
            }

            return number;
        }

        private void flood(char[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                return;
            }

            if (grid[row][col] == '1') {
                grid[row][col] = '0';
                flood(grid, row + 1, col);
                flood(grid, row - 1, col);
                flood(grid, row, col + 1);
                flood(grid, row, col - 1);
            }
        }
    }

}
