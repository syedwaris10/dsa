package com.dp.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongesPalindromicSubsequnece {

    public int longestPalindromeSubseq(String s1) {
        int[][] dp = new int[s1.length() + 1][s1.length() + 1];
        String s2 = reverseString(s1);
        System.out.println(s2);
        int max = 0;
        int n = s1.length();
        int m = s2.length();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        String str = "";
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                str = str + s1.charAt(i);
                if (isPalindrome(str)) {
                    max = Math.max(max, str.length());
                }
                i = i + 1;
                j = j + 1;
            } else {
                if (dp[i + 1][j] > dp[i][j + 1]) {
                    i = i + 1;
                } else {
                    j = j + 1;
                }
            }
        }

       // System.out.println("dp: " + str);
        System.out.println(max);
        return dp[0][0];

    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }

    private String reverseString(String s) {
        int i = 0, j = s.length() - 1;
        char[] c = s.toCharArray();
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        LongesPalindromicSubsequnece l = new LongesPalindromicSubsequnece();
        l.longestPalindromeSubseq("cbbd");
    }
}
