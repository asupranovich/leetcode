package org.asupranovich.leetcode.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lc57InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> intervalsList = new ArrayList<>(intervals.length + 1);

        if (newInterval[1] < intervals[0][0]) {
            intervalsList.add(newInterval);
            Collections.addAll(intervalsList, intervals);
        } else if (intervals[intervals.length - 1][1] < newInterval[0]) {
            Collections.addAll(intervalsList, intervals);
            intervalsList.add(newInterval);
        } else {
            int[] interval;
            int i = 0;
            for (; i < intervals.length; i++) {
                interval = intervals[i];
                if (interval[1] < newInterval[0]) {
                    intervalsList.add(interval);
                    continue;
                }
                if (interval[0] <= newInterval[0] && interval[1] >= newInterval[1]) {
                    // newInterval is included in some interval
                    return intervals;
                }

                if (interval[0] > newInterval[1]) {
                    intervalsList.add(newInterval);
                    intervalsList.add(interval);
                    break;
                }

                if (interval[0] <= newInterval[0] || newInterval[0] <= interval[1]) {
                    int[] mergedInterval = new int[]{Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])};
                    intervalsList.add(mergedInterval);

                    int[] nextInterval;
                    while (i < intervals.length - 1) {
                        i++;
                        nextInterval = intervals[i];
                        if (nextInterval[0] > newInterval[1]) {
                            intervalsList.add(nextInterval);
                            break;
                        } else if (nextInterval[1] >= newInterval[1]) {
                            mergedInterval[1] = nextInterval[1];
                            break;
                        }
                    }
                    break;
                }
            }
            i++;
            while (i < intervals.length) {
                intervalsList.add(intervals[i++]);
            }
        }

        return intervalsList.toArray(new int[][]{});
    }

}
