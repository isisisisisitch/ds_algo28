package ca.bytetube._15_greedy;

import java.util.Arrays;

public class ChangeCoins {
    public static void main(String[] args) {
        int[] coins = {25, 20, 5, 1};

        System.out.println(changeCoins(coins, 41));
    }

    public static int changeCoins(int[] coins, int change) {
        if (coins == null || coins.length == 0 || change == 0) return 0;
        Arrays.sort(coins);
        int total = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (change < coins[i]) continue;
            change -= coins[i];
            System.out.print("coin:" + coins[i] + " ");
            System.out.println();
            total++;
            i++;
        }
        return total;
    }
}
