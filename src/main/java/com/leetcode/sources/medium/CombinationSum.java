package com.leetcode.sources.medium;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        List<List<Integer>> combinationSum = combinationSum(candidates, 8);
        combinationSum.stream().map(Object::toString).forEach(System.out::println);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<Integer> numSet = Arrays.stream(candidates)
                .boxed()
                .collect(Collectors.toSet());

        Set<List<Integer>> resultSet = new LinkedHashSet<>();

        for (int i = 0; i < candidates.length; i++) {

            int firstCandidate = candidates[i];

            int etcCandidateSum = target - firstCandidate;

            for (int j = i; j < candidates.length; j++) {

                int mod = etcCandidateSum % candidates[j];
                if (mod == 0) {
                    List<Integer> list = new LinkedList<>();
                    System.out.println("1 firstCandidate : " + firstCandidate);
                    list.add(firstCandidate);
                    int etcCandidateCount = etcCandidateSum / candidates[j];
                    for (int k = 0; k < etcCandidateCount; k++) {
                        System.out.println("1 candidates[j] : " + candidates[j]);
                        list.add(candidates[j]);
                    }
                    resultSet.add(list);
                    System.out.println();
                } else if (numSet.contains(firstCandidate + mod) && numSet.contains(candidates[j])) {
                    List<Integer> list = new LinkedList<>();
                    System.out.println("2 firstCandidate : " + firstCandidate);
                    int sum = firstCandidate;
                    list.add(firstCandidate);
                    System.out.println("j : " + j);
                    int etcCandidateCount = etcCandidateSum / candidates[j];
                    for (int k = 0; k < etcCandidateCount - 1; k++) {
                        System.out.println("2 candidates[j] : " + candidates[j]);
                        list.add(candidates[j]);
                        sum+=candidates[j];
                    }
                    sum += (firstCandidate + mod);
                    list.add(firstCandidate + mod);
                    System.out.println("firstCandidate + mod : " + (firstCandidate + mod));
                    System.out.println("sum : " + sum);
                    if (sum == target) {
                        resultSet.add(list);
                    }
                    System.out.println();
                }

            }

        }

        return resultSet.stream()
                .map(ArrayList::new)
                .collect(Collectors.toList());

    }

}
