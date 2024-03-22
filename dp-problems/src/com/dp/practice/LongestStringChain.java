package com.dp.practice;

import java.util.Arrays;

public class LongestStringChain {

    String[] words;
    public int longestStrChain(String[] words) {
        this.words = words;
        Arrays.sort(words, (a, b) -> {return a.length() - b.length();});
        int ans = helper(0, -1);
        System.out.println(ans);
        return ans;
    }

    private int helper(int curr, int prev) {
        if (curr >= words.length) return 0;

        int skip = helper(curr + 1, prev);
        int take = 0;
        if (prev == -1 || ((words[curr].length() - words[prev].length() == 1) && predec(words[curr], words[prev]))) {
            take = 1 + helper(curr + 1, curr);
        }
        return Math.max(skip, take);
    }

    private boolean predec(String curr, String prev) {
        int p1 = curr.length() - 1;
        int p2 = prev.length() - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (curr.charAt(p1) != curr.charAt(p2)) {
                p1--;
            } else {
                p1--;
                p2--;
            }
        }

        return p2 <= 0;
    }

    public static void main(String[] args) {
        LongestStringChain longestStringChain = new LongestStringChain();
        longestStringChain.longestStrChain(new String[]{"a","b","ab","bac"});
    }
}
