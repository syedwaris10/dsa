package com.dp.practice;

import java.util.Arrays;

import static java.util.Arrays.fill;

public class HouseRobber {
    private Integer[] memo;
    private int[] nums;

    /**
     * Problem:
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed,
     * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
     * <p>
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     *
     * @param nums
     * @return
     */
    public int rob1(int[] nums) { //House Robber I
        this.memo = new Integer[nums.length];
        this.nums = nums;

        return getMax(0);
    }

    private int getMax(int i) {
        if (i >= nums.length) return 0;
        if (memo[i] != null) return memo[i];
        return memo[i] = Math.max(nums[i] + getMax(i + 2), getMax(i + 1));
    }


    /**
     * Problem:
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
     * <p>
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        this.nums = nums;
        int ans1 = getMaxCost(0, nums.length - 2, memo);
        Arrays.fill(memo, -1);
        int ans2 = getMaxCost(1, nums.length - 1, memo);
        return Math.max(ans1, ans2);
    }


    private int getMaxCost(int start, int end, int[] memo) {
        if (start >= nums.length || start > end) return 0;

        if (memo[start] != -1) {
            return memo[start];
        }

        return memo[start] = Math.max(nums[start] + getMaxCost(start + 2, end, memo), getMaxCost(start + 1, end, memo));

    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int res = houseRobber.rob2(new int[]{2, 3, 2});
        System.out.println(res);


    }
}
