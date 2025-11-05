package org.asupranovich.leetcode.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc905SortArrayByParity {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.sortArrayByParity(new int[] {1,3,5,7,2,4})));
    }

    static class Solution1 {
        public int[] sortArrayByParity(int[] nums) {
            if (nums.length < 2) {
                return nums;
            }

            int oddIndex = -1;
            int evenIndex;
            int temp;

            while (true) {
                oddIndex = getOddIndex(oddIndex + 1, nums);
                if (oddIndex == -1) {
                    break;
                }
                evenIndex = getEvenIndex(oddIndex + 1, nums.length - 1, nums);
                if (evenIndex == -1) {
                    break;
                }
                temp = nums[oddIndex];
                nums[oddIndex] = nums[evenIndex];
                nums[evenIndex] = temp;
            }

            return nums;
        }

        private int getEvenIndex(int left, int right, int[] nums) {
            for (int i = right; i >= left; i--) {
                if (nums[i] % 2 == 0) {
                    return i;
                }
            }
            return -1;
        }

        private int getOddIndex(int start, int[] nums) {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] % 2 > 0) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class Solution2 {
        public int[] sortArrayByParity(int[] nums) {
            if (nums.length < 2) {
                return nums;
            }

            List<Integer> oddList = new ArrayList<>();
            List<Integer> evenList = new ArrayList<>();

            for (int num : nums) {
                if (num % 2 == 0) {
                    evenList.add(num);
                } else {
                    oddList.add(num);
                }
            }
            if (oddList.isEmpty() || evenList.isEmpty()) {
                return nums;
            }

            int[] result = new int[nums.length];
            for (int i = 0; i < evenList.size(); i++) {
                result[i] = evenList.get(i);
            }
            for (int i = 0; i < oddList.size(); i++) {
                result[i + evenList.size()] = oddList.get(i);
            }

            return result;
        }
    }

}
