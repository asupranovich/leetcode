package org.asupranovich.leetcode.arr;

import java.util.*;
import java.util.Map.Entry;

public class Lc347TopKFrequentElements {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[] {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6}, 3)));
    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.merge(num, 1, Integer::sum);
            }

            PriorityQueue<Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Entry::getValue));

            map.entrySet().forEach(e -> {
                    priorityQueue.add(e);
                    if (priorityQueue.size() > k) {
                        priorityQueue.poll();
                    }
                }
            );

            return priorityQueue.stream().mapToInt(Entry::getKey).toArray();


            /*Map<Integer, List<Integer>> reverseMap = new HashMap<>();
            for (Integer key : map.keySet()) {
                Integer value = map.get(key);
                reverseMap.computeIfAbsent(value, (k1) -> new ArrayList<>()).add(key);
            }

            List<Integer> occurances = new ArrayList<>(reverseMap.keySet());
            occurances.sort(Comparator.reverseOrder());
            System.out.println(occurances);

            Iterator<Integer> occIterator = occurances.iterator();
            while (topNumbers.size() < k && occIterator.hasNext()) {
                Integer occ = occIterator.next();
                topNumbers.addAll(reverseMap.get(occ));
            }

            int[] result = new int[topNumbers.size()];
            for (int i = 0; i < topNumbers.size(); i++) {
                result[i] = topNumbers.get(i);
            }

            return result;*/
        }
    }

}
