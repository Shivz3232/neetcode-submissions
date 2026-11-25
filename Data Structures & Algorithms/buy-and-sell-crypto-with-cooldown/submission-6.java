class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        boolean[][] seen = new boolean[n][2];
        int[][] memo = new int[n][2];

        return dfs(0, 0, prices, memo, seen);
    }

    private int dfs(int i, int bought, int[] prices, int[][] memo, boolean[][] seen) {
        if (i >= prices.length) {
            return 0;
        }

        if (seen[i][bought]) return memo[i][bought];

        if (bought == 1) {
            memo[i][bought] = Math.max(
                dfs(i + 1, 1, prices, memo, seen),
                dfs(i + 2, 0, prices, memo, seen) + prices[i]
            );
        } else {
            memo[i][bought] = Math.max(
                dfs(i + 1, 0, prices, memo, seen),
                dfs(i + 1, 1, prices, memo, seen) - prices[i]
            );
        }

        seen[i][bought] = true;

        return memo[i][bought];
    }
}
