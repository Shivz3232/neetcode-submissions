class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Map<Integer, Integer> memo = new HashMap<>();

        dfs(coins, amount, memo);

        // System.out.println(memo);
        
        return memo.get(amount);
    }

    private int dfs(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (amount == 0) return 0;
        if (memo.containsKey(amount)) return memo.get(amount);

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amount) continue;

            int temp = dfs(coins, amount - coin, memo);
            if (temp == -1) continue;

            if (temp + 1 < minCoins) {
                minCoins = temp + 1;
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
