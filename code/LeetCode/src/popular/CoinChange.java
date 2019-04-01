package popular;

import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;

        if (count == Integer.MAX_VALUE) {
            count = -1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{186, 419, 83, 408};
        int amount = 6249;
        System.out.println("Output: " + coinChange(coins, amount));
    }
}
