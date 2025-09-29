package org.asupranovich.leetcode.arr;

import java.util.Arrays;

public class DutchNationalFlagProblem {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sort(new int[] {2, 2, 2 ,0, 2, 1, 0, 2, 1, 1, 2, 0, 0, 0, 0})));
    }

    static class Solution {

        public int[] sort(int[] arr) {
            int i = 0;
            for (int val = 0; val < 3; val++) {
                i = getNextIndex(arr, i, val);
                if (i == arr.length) {
                    return arr;
                }

                int j = i + 1;
                while (j < arr.length) {
                    if (arr[j] == val) {
                        int temp = arr[i];
                        arr[i] = val;
                        arr[j] = temp;
                        i = getNextIndex(arr, i, val);
                    }
                    j++;
                }
            }
            return arr;
        }

        private int getNextIndex(int[] arr, int i, int target) {
            while (i < arr.length && arr[i] == target) {
                i++;
            }
            return i;
        }

    }

}
