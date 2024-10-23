package org.asupranovich.leetcode.arr;

import java.util.Arrays;

public class Lc238ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4, 5})));
    }

    static class Solution {

        public int[] productExceptSelf(int[] nums) {
            int[] result = new int[nums.length];

            int prefixProduct = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                int current = nums[i];
                result[i] = prefixProduct;
                prefixProduct *= current;
            }
            result[nums.length - 1] = prefixProduct;

            int suffixProduct = 1;
            for (int i = nums.length - 1; i > 0; i--) {
                int current = nums[i];
                result[i] = result[i] * suffixProduct;
                suffixProduct *= current;
            }
            result[0] = suffixProduct;

            return result;
        }
    }

}
