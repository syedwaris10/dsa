package com.dp.practice;

public class FrogJump {
    static Integer[] memo;
    static int[] heights;
    public static int frogJump(int n, int heights[]) {
        FrogJump.memo = new Integer[n + 1];
        FrogJump.heights = heights;
        return minEnergy(1, n);
    }

    private static int minEnergy(int curr, int n) {
        if (curr >= n) return 0;

        if (curr == n - 1) {
            return Math.abs(heights[curr] - heights[curr - 1]);
        }
        if (memo[curr] != null) {
            return memo[curr];
        }

        int ans1 = Math.abs(heights[curr] - heights[curr - 1]) + minEnergy(curr + 1, n);
        int ans2 = Math.abs(heights[curr + 1] - heights[curr - 1]) + minEnergy(curr + 2, n);
        return memo[curr] = Math.min(ans1, ans2);
    }

    public static void main(String[] args) {
        int ans = FrogJump.frogJump(4, new int[]{10, 20, 30, 10});
        System.out.println(ans);
    }
}
