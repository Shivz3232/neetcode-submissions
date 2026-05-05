class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        int[] reversed = Arrays.stream(coins)
                       .boxed()
                       .sorted(Collections.reverseOrder())
                       .mapToInt(Integer::intValue)
                       .toArray();

        int[] memo = new int[2];

        dfs(reversed, amount, memo);

        if (memo[0] == 1) {
            return memo[1];
        } else {
            return -1;
        }
    }

    private void dfs(int[] coins, int amount, int[] memo) {
        if (amount < 0) {
            return;
        }

        if (amount == 0) {
            memo[0] = 1;
            return;
        }

        for (int coin : coins) {
            memo[1]++;
            dfs(coins, amount - coin, memo);
            if (memo[0] == 1) {
                return;
            }
            memo[1]--;
        }
    }
}
