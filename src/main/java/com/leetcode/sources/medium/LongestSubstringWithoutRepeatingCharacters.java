package com.leetcode.sources.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    private static int lengthOfLongestSubstring(String s) {

        int idx = 0;
        int currentMax = 0;

        Set<Character> characters = new HashSet<>();

        while (idx < s.length()) {
            char character = s.charAt(idx);
            characters.add(character);

            int jump = 1;
            while (idx + jump < s.length()) {
                char newCharacter = s.charAt(idx + jump);
                if (characters.contains(newCharacter)) {
                    break;
                }

                characters.add(newCharacter);
                jump++;
            }

            currentMax = Math.max(currentMax, characters.size());

            idx++;
            System.out.println(characters);

            if (characters.size() >= s.length() - idx) {
                return currentMax;
            }

            characters.clear();
        }

        return currentMax;
    }


}
