class Solution {
    public int maxProfit(int[] prices) {
        return dfs(0, false, prices);
    }

    private int dfs(int i, boolean bought, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }

        if (bought) {
            return Math.max(
                dfs(i + 1, true, prices),
                dfs(i + 2, false, prices) + prices[i]
            );
        } else {
            return Math.max(
                dfs(i + 1, false, prices),
                dfs(i + 1, true, prices) - prices[i]
            );
        }
    }
}
