package com.dp.practice;

public class LongestCommonSubstring {

        public static int longestCommonSubstring(String str1, String str2) {
            return longestCommonSubstring(str1, str2, str1.length(), str2.length(), 0);
        }

        private static int longestCommonSubstring(String str1, String str2, int m, int n, int count) {
            if (m == 0 || n == 0) {
                return count;
            }

            if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                count = longestCommonSubstring(str1, str2, m - 1, n - 1, count + 1);
            }

            count = Math.max(count, Math.max(longestCommonSubstring(str1, str2, m, n - 1, 0), longestCommonSubstring(str1, str2, m - 1, n, 0)));

            return count;
        }

        public static void main(String[] args) {
            String str1 = "abcde";
            String str2 = "bce";
            int longestLength = longestCommonSubstring(str1, str2);
            System.out.println("Length of longest common substring: " + longestLength);
        }
    }
