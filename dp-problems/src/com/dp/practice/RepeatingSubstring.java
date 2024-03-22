package com.dp.practice;

import java.util.*;

public class RepeatingSubstring {
    Map<String, Integer> map = new LinkedHashMap<>();
    public String findAllRepeatingSubstring(String str) {
        dp(0, str);
        int maxLen = 0;
        String ans = "";
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
           if (entry.getKey().length() > ans.length()) {
               if (entry.getValue() > maxLen) {
                   maxLen = entry.getValue();
                   ans = entry.getKey();
               }
           }
        }


        System.out.println(map.keySet());
        return ans;
    }


    private void dp(int index, String str) {
        if (index == str.length()) {
            return;
        }
        for (int i = index + 1; i <= str.length(); i++) {
            map.put(str.substring(index, i), map.getOrDefault(str.substring(index, i), 0) + 1);
            dp(i + 1, str.substring(i));
        }
    }

    public static void main(String[] args) {
        RepeatingSubstring repeatingSubstring = new RepeatingSubstring();
        repeatingSubstring.findAllRepeatingSubstring("geeksforgeeks");
    }
}
