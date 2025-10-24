package org.asupranovich.leetcode.num;

import java.util.Arrays;

public class Lc492ConstructRectangle {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.constructRectangle(122122)));
    }

    static class Solution {
        public int[] constructRectangle(int area) {
            double sqrt = Math.sqrt(area);
            int length = (int) sqrt;
            int width = (int) sqrt;
            int mult = length * width;
            while (width > 1 && length < area && mult != area) {
                System.out.printf("%s * %s = %s \n", length, width, mult);
                if (mult > area) {
                    width--;
                } else {
                    length++;
                }
                mult = width * length;
            }
            if (length == area || width == 1) {
                return new int[] {area, 1};
            }
            return new int[] {length, width};
        }
    }

}
