package com.dp.practice;

public class CoinChange2 {
    int[] coins;
    Integer[][] memo;

    /**
     * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
     *
     * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
     *
     * You may assume that you have an infinite number of each kind of coin.
     *
     * The answer is guaranteed to fit into a signed 32-bit integer.
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.memo = new Integer[coins.length][amount + 1];
        return getComb(0, amount);
    }

    private int getComb(int index, int amt) {
        if (index >= coins.length) return 0;

        if (amt < 0) return 0;

        if (amt == 0) return 1;

        if (memo[index][amt] != null) {
            return memo[index][amt];
        }

        int skip = getComb(index + 1, amt);
        int take = getComb(index, amt - coins[index]);

        return memo[index][amt] = skip + take;
    }
}
