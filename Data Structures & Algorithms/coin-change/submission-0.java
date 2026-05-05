class Solution {
    public int coinChange(int[] coins, int amount) {
        return aux(coins, amount, 0);
    }

    private int aux(int[] coins, int amount, int nCoins) {
        if (amount < 0) return -1;
        if (amount == 0) return nCoins;

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int temp = aux(coins, amount - coins[i], nCoins + 1);
            if (temp != -1 && temp < result) {
                result = temp;
            }
        }

        if (result == Integer.MAX_VALUE) return -1;

        return result;
    }
}
