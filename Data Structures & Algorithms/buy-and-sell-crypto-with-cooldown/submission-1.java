class Solution {
    public int maxProfit(int[] prices) {
        return Math.max(
            dfs(0, 0, 0, 1, prices, new HashMap<>()),
            dfs(prices[0], 0, 1, 1, prices, new HashMap<>())
        );
    }

    private int dfs(int holding, int profit, int state, int i, int[] prices, Map<Integer, Integer> memo) {
        if (i >= prices.length) {
            System.out.println(profit);
            return profit;
        }

        if (state == 0) {
            if (memo.containsKey(i)) {
                return memo.get(i);
            } else {
                int result = Math.max(
                    dfs(0, profit, 0, i + 1, prices, memo),
                    dfs(prices[i], profit, 1, i + 1, prices, memo)
                );

                memo.put(i, result);

                return result;
            }
        } else if (state == 1) {
            return Math.max(
                dfs(0, profit + prices[i] - holding, 2, i + 1, prices, memo),
                dfs(holding, profit, 1, i + 1, prices, memo)
            );
        } else {
            return dfs(0, profit, 0, i + 1, prices, memo);
        }
    }
}
