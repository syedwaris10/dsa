package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cards {

    public int minimumCardPickup(int[] cards) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            map.putIfAbsent(cards[i], new ArrayList<>());
            map.get(cards[i]).add(i);
        }

        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            int key = entry.getKey();
            List<Integer> value = entry.getValue();
            if (value.size() > 1) {
                int range = value.get(value.size() - 1) - value.get(0) + 1;
                min = Math.min(min, range);
            }

        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        Cards cards = new Cards();
        //[95,11,8,65,5,86,30,27,30,73,15,91,30,7,37,26,55,76,60,43,36,85,47,96,6]
        cards.minimumCardPickup(new int[]{95,11,8,65,5,86,30,27,30,73,15,91,30,7,37,26,55,76,60,43,36,85,47,96,6});
    }
}
