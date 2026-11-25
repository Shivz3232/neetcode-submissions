class Solution {
    public int maxProfit(int[] prices) {
        // ------------------
        // Bottup-Up Approach
        // ------------------

        int n = prices.length;

        if (n < 2) return 0;

        // 0 : Can buy
        // 1 : Can not buy
        int[][] memo = new int[n][2];

        int pos;

        // Hard code base cases for day n
        pos = n - 1;

        memo[pos][1] = prices[pos];

        // Hard code base cases for day n - 1
        pos = n - 2;

        memo[pos][0] = Math.max(
            memo[pos + 1][0],
            memo[pos + 1][1] - prices[pos]
        );

        memo[pos][1] = Math.max(
            memo[pos + 1][1],
            prices[pos] // Because memo[pos + 2] is invalid
        );

        for (int i = n - 3; i >= 0; i--) {
            // Update can buy
            memo[i][0] = Math.max(
                memo[i + 1][0],                 // Continue without buying
                memo[i + 1][1] - prices[i]      // Buy and continue
            );

            // Update cannot buy
            memo[i][1] = Math.max(
                memo[i + 1][1],                 // Continue without selling
                memo[i + 2][0] + prices[i]      // Sell and skip next day
            );
        }

        return memo[0][0];
    }
}
