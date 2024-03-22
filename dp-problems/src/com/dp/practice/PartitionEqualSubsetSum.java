package com.dp.practice;

public class PartitionEqualSubsetSum {
    private int[] nums;
    private Boolean[] memo;
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        this.memo = new Boolean[nums.length];

        return dp(0, 0, 0);
    }

    private boolean dp(int index, int sum1, int sum2) {
        if (index == nums.length) {
            if (sum1 == sum2) {
                return true;
            }
            return false;
        }
        if (memo[index] != null) {
            return memo[index];
        }

        if (dp(index + 1, sum1 + nums[index], sum2) || dp(index + 1, sum1, sum2 + nums[index])) {
            return memo[index] = true;
        }

        return memo[index] = false;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        boolean ans = partitionEqualSubsetSum.canPartition(new int[]{1,5,11,5});
        System.out.println(ans);
    }
}
