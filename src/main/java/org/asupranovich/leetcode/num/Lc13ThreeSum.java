package org.asupranovich.leetcode.num;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Lc13ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                count = 0;
            }
            map.put(num, ++count);
        }

        Set<List<Integer>> combinations = new HashSet<>();

        for (int first : nums) {
            for (int second : map.keySet()) {
                if (second == first && map.get(first) < 2) {
                    continue;
                }
                int third = 0 - first - second;
                if (first == second && second == third && map.get(first) < 3) {
                    continue;
                }
                if (third == first && map.get(first) < 2) {
                    continue;
                }
                if (third == second && map.get(second) < 2) {
                    continue;
                }
                if (map.get(third) != null) {
                    combinations.add(Stream.of(first, second, third).sorted().toList());
                }
            }
        }

        return new ArrayList<>(combinations);
    }

}
