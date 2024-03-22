package com.dp.practice;

public class CoinChange {
    Integer[][] memo;
    int[] coins;
    public int coinChange(int[] coins, int amount) {
        this.memo = new Integer[coins.length][amount + 1];
        this.coins = coins;

        int count = getCount(0, amount);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private int getCount(int index, int amt) {
        if (index >= coins.length || amt < 0) return Integer.MAX_VALUE;

        if (amt == 0) return 0;
        if (memo[index][amt] != null) {
            return memo[index][amt];
        }
        int skip = getCount(index + 1, amt);
        int take = getCount(index, amt - coins[index]);
        if (take < Integer.MAX_VALUE) {
            take++;
        }

        return memo[index][amt] = Math.min(skip, take);
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int count = coinChange.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(count);
    }
}
