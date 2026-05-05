class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Map<Integer, Integer> memo = new HashMap<>();
        
        return dfs(coins, amount, 0, memo);
    }

    private int dfs(int[] coins, int amount, int nCoins, Map<Integer, Integer> memo) {
        if (amount < 0) return -1;
        if (amount == 0) return nCoins;
        if (memo.containsKey(amount)) return memo.get(amount);

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int temp = dfs(coins, amount - coin, nCoins + 1, memo);
            if (temp != -1 && temp < minCoins) {
                minCoins = temp;
            }
        }

        if (minCoins == Integer.MAX_VALUE) {
            memo.put(amount, -1);
            return -1;
        } else {
            memo.put(amount, minCoins);
            return minCoins;
        }
    }
}
