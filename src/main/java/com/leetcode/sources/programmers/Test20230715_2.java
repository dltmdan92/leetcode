package com.leetcode.sources.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Test20230715_2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(
                        new String[][] {{"david", "frank"}, {"demi", "david"}, {"frank", "james"}, {"demi", "james"}, {"claire", "frank"}},
                        "david"
                )
        ));
    }

    public static String[] solution(String[][] friends, String user_id) {
        Map<String, Set<String>> map = new HashMap<>();

        for (String[] friendShip : friends) {
            String x = friendShip[0];
            String y = friendShip[1];

            if (!map.containsKey(x)) {
                map.put(x, new HashSet<>());
            }

            if (!map.containsKey(y)) {
                map.put(y, new HashSet<>());
            }

            map.get(x).add(y);
            map.get(y).add(x);
        }

        Set<String> userfriends = map.get(user_id);

        Map<String, Long> mutualFriendCounting = userfriends.stream()
                .filter(map::containsKey)
                .map(map::get)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(mutualFriend -> mutualFriend, Collectors.counting()));

        Long max = mutualFriendCounting.values().stream().max(Comparator.comparingLong(x -> x)).get();

        return mutualFriendCounting.entrySet().stream()
                .filter(entry -> max.equals(entry.getValue()))
                .filter(entry -> !entry.getKey().equals(user_id))
                .map(Map.Entry::getKey)
                .sorted()
                .toArray(String[]::new);
    }

}
