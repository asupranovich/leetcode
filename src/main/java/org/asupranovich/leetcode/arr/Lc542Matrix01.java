package org.asupranovich.leetcode.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc542Matrix01 {

    public int[][] updateMatrix(int[][] mat) {
        var result = new int[mat.length][mat[0].length];
        for (var row : result) {
            Arrays.fill(row, -1);
        }

        List<int[]> toProcess = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    toProcess.add(new int[]{i, j});
                }
            }
        }

        while(!toProcess.isEmpty()) {
            toProcess = toProcess.stream().flatMap(pair -> tryChange(pair, result).stream()).toList();
        }

        return result;
    }

    private List<int[]> tryChange(int[] pair, int[][] matrix) {
        int row = pair[0];
        int column = pair[1];
        int workValue = matrix[row][column];
        List<int[]> changed = new ArrayList<>();

        if (row - 1 >= 0 && matrix[row - 1][column] == -1) {
            matrix[row - 1][column] = workValue + 1;
            changed.add(new int[] {row - 1, column});
        }

        if (column + 1 < matrix[row].length && matrix[row][column + 1] == -1) {
            matrix[row][column + 1] = workValue + 1;
            changed.add(new int[] {row, column + 1});
        }

        if (row + 1 < matrix.length && matrix[row + 1][column] == -1) {
            matrix[row + 1][column] = workValue + 1;
            changed.add(new int[] {row + 1, column});
        }

        if (column - 1 >= 0 && matrix[row][column - 1] == -1) {
            matrix[row][column - 1] = workValue + 1;
            changed.add(new int[] {row, column - 1});
        }

        return changed;
    }

}
