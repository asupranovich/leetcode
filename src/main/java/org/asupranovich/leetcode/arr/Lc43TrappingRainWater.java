package org.asupranovich.leetcode.arr;

import java.util.Deque;
import java.util.LinkedList;

public class Lc43TrappingRainWater {

    public static void main(String[] args) {
        Lc43TrappingRainWater solution = new Lc43TrappingRainWater();
        System.out.println(solution.trap(new int[] {5,5,1,7,1,1,5,2,7,6}));
    }

    public int trap(int[] heights) {
        Deque<Max> maxes = getMaxes(heights);
        int trappedWater = 0;

        while (maxes.size() > 1) {
            Max max = maxes.pollFirst();
            int waterLevel = Math.min(max.height, max.nextMaxHeight);
            for (int i = max.index + 1; i < max.nextMaxIndex; i++) {
                int currHeight = heights[i];
                if (currHeight < waterLevel) {
                    trappedWater += waterLevel - currHeight;
                } else if (currHeight >= max.height) {
                    break;
                }
            }
            while (!maxes.isEmpty() && maxes.peekFirst().height < waterLevel) {
                maxes.pollFirst();
            }
        }

        return trappedWater;
    }

    private Deque<Max> getMaxes(int[] heights) {
        Deque<Max> maxes = new LinkedList<>();

        int nextMaxIndex = -1;
        int nextMaxHeight = -1;

        int next = -1;
        for (int i = heights.length - 1; i >= 0; i--) {
            int curr = heights[i];
            int prev = i == 0 ? Integer.MIN_VALUE : heights[i - 1];
            if (curr >= prev && curr >= next) {
                Max max = new Max();
                max.index = i;
                max.height = curr;
                max.nextMaxIndex = nextMaxIndex;
                max.nextMaxHeight = nextMaxHeight;
                maxes.addFirst(max);

                if (curr >= nextMaxHeight) {
                    nextMaxHeight = curr;
                    nextMaxIndex = i;
                }
            }
            next = curr;
        }
        return maxes;
    }

    static class Max {
        private int index;
        private int height;
        private int nextMaxIndex;
        private int nextMaxHeight;
    }
}
