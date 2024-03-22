package com.dp.practice;

public class LargestSumNonAdjacent {

    public int getSum(int[] arr) {
        return dp(0, -1, arr);
    }

    private int dp(int curr, int prev, int[] arr) {
        if (curr >= arr.length) return 0;

        int ans = dp(curr + 1, prev, arr);

        if (prev == -1 || curr - prev != 0) {
            ans = Math.max(ans, arr[curr] + dp(curr + 2, curr, arr));
        }

        return ans;
    }

    public static void main(String[] args) {
        LargestSumNonAdjacent l = new LargestSumNonAdjacent();
        int ans = l.getSum(new int[]{-2, -4, 6, 2, 5});
        System.out.println(ans);

        String url = "https://leetcode.com/problems/abc";
        String[] s = url.split("com");
    }
}
