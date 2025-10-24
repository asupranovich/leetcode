package org.asupranovich.leetcode.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lc349IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 3, 5, 6, 2, 3, 1, 5 ,8};
        int[] nums2 = new int[] {3, 8, 9 , 12, 8 , 45, 66};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersection(nums1, nums2)));
    }

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            int nums1Length = nums1.length;
            int nums2Length = nums2.length;
            if (nums1Length == 0 || nums2Length == 0) {
                return new int[0];
            }

            Set<Integer> set1 = toSet(nums1);
            Set<Integer> set2 = toSet(nums2);
            List<Integer> common = new ArrayList<>();

            if (nums1Length < nums2Length) {
                for (int i : set1) {
                    if (set2.contains(i)) {
                        common.add(i);
                    }
                }
            } else {
                for (int i : set2) {
                    if (set1.contains(i)) {
                        common.add(i);
                    }
                }
            }
            return common.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        }

        private Set<Integer> toSet(int[] nums) {
            return IntStream.of(nums)
                .boxed()
                .collect(Collectors.toSet());
        }
    }

}
