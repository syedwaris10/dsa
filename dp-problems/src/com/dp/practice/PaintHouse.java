package com.dp.practice;

public class PaintHouse {
    int[][] arr;
    Integer[][] memo;
    public int getMinCostOfPainitng(int[][] arr) {
        //0 - red, 1 - green, 2 - blue
        this.arr = arr;
        this.memo = new Integer[arr.length][3];
        int ans = dp(0, 0);
        int ans1 = dp(0, 1);
        int ans2 = dp(0, 2);
        System.out.println(Math.min(ans, Math.min(ans1, ans2)));
        return ans;

    }

    private  int dp(int house, int color) {
        if (house == arr.length) return 0;
        if (memo[house][color] != null) {
            return memo[house][color];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != color) {
                min = Math.min(min, arr[house][color] + dp(house + 1, i));
            }
        }

        // Memoize the result
       // memo[house][color] = minCost;
        return memo[house][color] = min;
    }

    public static void main(String[] args) {
        PaintHouse paintHouse = new PaintHouse();
        paintHouse.getMinCostOfPainitng(new int[][]{{14, 2, 11},{11, 14, 5},{14, 3, 10}});
    }
}
