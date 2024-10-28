package org.asupranovich.leetcode.arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lc207CourseSchedule {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.canFinish(7, new int [][] {
            {1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}
        }));
    }

    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Checker checker = new Checker(numCourses, prerequisites);
            return checker.check();
        }

        class Checker {
            final Map<Integer, List<Integer>> prereqsMap;
            final int numCourses;
            final Set<Integer> takenCourses = new HashSet<>();

            Checker(int numCourses, int[][] prerequisites) {
                this.numCourses = numCourses;
                this.prereqsMap = Arrays.stream(prerequisites)
                    .collect(Collectors.groupingBy(p -> p[0], Collectors.mapping(p -> p[1], Collectors.toList())));
            }

            private boolean check() {
                for (int course = 0; course < numCourses; course++) {
                    Set<Integer> chain = new HashSet<>();
                    Set<Integer> collector = new HashSet<>();
                    boolean result = checkRecursively(course, chain, collector);
                    if (!result) {
                        return false;
                    }
                    takenCourses.addAll(collector);
                }
                return true;
            }

            private boolean checkRecursively(Integer course, Set<Integer> chain, Set<Integer> collector) {
                if (takenCourses.contains(course)) {
                    return true;
                }
                List<Integer> coursePrereqs = prereqsMap.get(course);
                if (coursePrereqs == null) {
                    collector.add(course);
                    return true;
                }
                for (Integer coursePrereq : coursePrereqs) {
                    if (takenCourses.contains(coursePrereq)) {
                        continue;
                    }
                    if (chain.contains(coursePrereq)) { // circular dependency
                        return false;
                    }
                    chain.add(course);
                    collector.add(course);
                    Set<Integer> branchChain = coursePrereqs.size() > 1 ? new HashSet<>(chain) : chain;
                    if (!checkRecursively(coursePrereq, branchChain, collector)) {
                        return false;
                    }
                }

                return true;
            }
        }
    }


}
