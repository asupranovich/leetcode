package org.asupranovich.leetcode.arr;

import java.util.Arrays;
import java.util.Comparator;

public class Lc973KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        if (k >= points.length) {
            return points;
        }

        int[][] result = new int[k][2];
        System.arraycopy(points, 0, result, 0, k);
        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[0] * a[0] + a[1] * a[1]);
        Arrays.sort(result, comparator);

        int[] lastPoint = result[k - 1];
        for (int i = k; i < points.length; i++) {
            if (comparator.compare(lastPoint, points[i]) > 0) {
                result[k - 1] = points[i];
                Arrays.sort(result, comparator);
                lastPoint = result[k - 1];
            }
        }

        return result;
    }

}
