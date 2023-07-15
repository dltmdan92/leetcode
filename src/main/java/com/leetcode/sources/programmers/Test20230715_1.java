package com.leetcode.sources.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test20230715_1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"ABACDEFG", "NOPQRSTU", "HIJKLKMM"}, new String[] {"GPQM", "GPMZ", "EFU", "MMNA"})));
    }

    private static String[] solution(String[] card, String[] word) {

        // KEY: 알파벳, VALUE: count
        Map<String, Long> line1 = Arrays.stream(card[0].split(""))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        Map<String, Long> line2 = Arrays.stream(card[1].split(""))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        Map<String, Long> line3 = Arrays.stream(card[2].split(""))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        List<String> successWordList = new LinkedList<>();

        for (String targetWord : word) {
            boolean usedLine1 = false;
            boolean usedLine2 = false;
            boolean usedLine3 = false;

            Map<String, Long> targetAlphabetCounting = Arrays.stream(targetWord.split(""))
                    .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

            for (Map.Entry<String, Long> entry : targetAlphabetCounting.entrySet()) {
                String alphabet = entry.getKey();
                Long alphabetCount = entry.getValue();

                if (line1.containsKey(alphabet) && (line1.get(alphabet).equals(alphabetCount) || line1.get(alphabet) > alphabetCount)) {
                    usedLine1 = true;
                } else if (line2.containsKey(alphabet) && (line2.get(alphabet).equals(alphabetCount) || line2.get(alphabet) > alphabetCount)) {
                    usedLine2 = true;
                } else if (line3.containsKey(alphabet) && (line3.get(alphabet).equals(alphabetCount) || line3.get(alphabet) > alphabetCount)) {
                    usedLine3 = true;
                } else {
                    usedLine1 = false;
                    usedLine2 = false;
                    usedLine3 = false;
                    break;
                }
            }

            if (usedLine1 && usedLine2 && usedLine3) {
                successWordList.add(targetWord);
            }
        }

        if (successWordList.isEmpty()) {
            return new String[] {"-1"};
        }

        return successWordList.toArray(new String[0]);
    }

}
