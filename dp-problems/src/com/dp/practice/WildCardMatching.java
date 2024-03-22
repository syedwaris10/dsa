package com.dp.practice;

public class WildCardMatching {

    String s;
    String p;
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        this.memo = new Boolean[s.length() + 1][p.length() + 1];
        return helper(0, 0);
    }

    private boolean helper(int i, int j) {
        // if (memo[i][j] != null) {
        //     return memo[i][j];
        // }
        if (i == s.length() && j == p.length()) {
            return true;
        }
        if (j == p.length()) {
            return false;
        }
        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
                return true;
            }
        }

        boolean match = false;
        if (p.charAt(j) == '*') {
            return helper(i + 1, j) || helper(i, j + 1);
        }

        else if (p.charAt(j) == '?') {
            return helper(i + 1, j + 1);
        }

        else if (p.charAt(j) == s.charAt(i)) {
            return helper(i + 1, j + 1);
        }
        return false;

    }

    public static void main(String[] args) {
        WildCardMatching wildCardMatching = new WildCardMatching();
        boolean ans = wildCardMatching.isMatch("acdcb", "a*c?b");
        System.out.println(ans);
    }
}
