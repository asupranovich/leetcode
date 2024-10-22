package org.asupranovich.leetcode.num;

import java.util.Arrays;

public class Lc322CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        return change(coins, coins.length, amount);
    }

    public int change(int[] coins, int limit, int amount) {
        if (limit == 0 || amount < coins[0]) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int counter = 20;
        for (int i = limit - 1; i >= 0; i--) {
            int coin = coins[i];
            if (coin > amount) {
                continue;
            }
            int reminder = amount % coin;
            int coinCount = amount / coin;
            if (min < coinCount) {
                break;
            }
            if (reminder == 0) {
                return coinCount;
            } else if (i > 0) {
                while (coinCount > 0) {
                    reminder = amount - coin * coinCount;
                    int reminderCoinCount = change(coins, i, reminder);
                    if (reminderCoinCount > 0) {
                        min = Math.min(min, coinCount + reminderCoinCount);
                        if (limit == coins.length && --counter <= 0) {
                            return min;
                        }
                    }
                    coinCount--;
                }
            }
        }
        return min < Integer.MAX_VALUE ? min : -1;
    }

}
