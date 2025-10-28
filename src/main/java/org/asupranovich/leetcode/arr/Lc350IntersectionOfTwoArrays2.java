package org.asupranovich.leetcode.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc350IntersectionOfTwoArrays2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] intersect = solution.intersect(new int[]{1, 7, 4, 4, 5, 2, 7, 19}, new int[]{4, 4, 8, 9, 7, 3, 18, 88});
        System.out.println(Arrays.toString(intersect));
    }

    static class Solution {

        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length == 0 || nums2.length == 0) {
                return new int[0];
            }

            Arrays.sort(nums1);
            Arrays.sort(nums2);

            List<Integer> intersection = new ArrayList<>();
            int nums1Index = 0;
            int nums2Index = 0;

            while (nums1Index < nums1.length && nums2Index < nums2.length) {
                int nums1Value = nums1[nums1Index];
                int nums2Value = nums2[nums2Index];
                if (nums1Value == nums2Value) {
                    intersection.add(nums1Value);
                    nums1Index++;
                    nums2Index++;
                    continue;
                }
                if (nums1Value > nums2Value) {
                    nums2Index++;
                } else {
                    nums1Index++;
                }
            }

            int[] result = new int[intersection.size()];
            for (int i = 0; i < intersection.size(); i++) {
                result[i] = intersection.get(i);
            }

            return result;
        }
    }

}
