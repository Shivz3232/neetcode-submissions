class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) memo[i] = Integer.MAX_VALUE;

        aux(coins, amount, 0, memo);

        for (int i = 1; i < amount + 1; i++) System.out.print(memo[i] + ", ");
        System.out.println();

        return memo[amount];
    }

    private int aux(int[] coins, int amount, int nCoins, int[] memo) {
        if (amount < 0) return -1;
        if (amount == 0) return nCoins;
        if (memo[amount] != Integer.MAX_VALUE) return memo[amount];

        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int temp = aux(coins, amount - coins[i], 1, memo);
            if (temp != -1 && temp < minCoins) {
                minCoins = temp;
            }
        }

        if (minCoins == Integer.MAX_VALUE) {
            memo[amount] = -1;
            return -1;
        }

        memo[amount] = minCoins;
        return minCoins;
    }
}
