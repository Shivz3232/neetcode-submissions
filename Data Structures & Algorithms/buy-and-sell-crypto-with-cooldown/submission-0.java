class Solution {
    public int maxProfit(int[] prices) {
        return Math.max(
            dfs(0, 0, 0, 1, prices),
            dfs(prices[0], 0, 1, 1, prices)
        );
    }

    // State 0 => Not bought
    // State 1 => bought
    // State 2 => Recently sold

    private int dfs(int holding, int profit, int state, int i, int[] prices) {
        if (i >= prices.length) {
            // System.out.printf("%d, %d\n", holding, profit);
            return profit;
        }

        if (state == 0) {
            return Math.max(
                dfs(0, profit, 0, i + 1, prices),
                dfs(prices[i], profit, 1, i + 1, prices)
            );
        } else if (state == 1) {
            return Math.max(
                dfs(0, profit + prices[i] - holding, 2, i + 1, prices),
                dfs(holding, profit, 1, i + 1, prices)
            );
        } else {
            return dfs(0, profit, 0, i + 1, prices);
        }
    }
}
