class Solution {
    public int maxProfit(int[] prices) {
        List<List<HashMap<Integer, Integer>>> memo = new ArrayList<>();

        for (int i = 0; i < prices.length; i++) {
            List<HashMap<Integer, Integer>> l = new ArrayList<>();

            for (int state = 0; state < 3; state++) {
                l.add(new HashMap<>());
            }

            memo.add(l);
        }

        memo.get(0).get(0).put(0, dfs(0, 0, 0, 1, prices, memo));
        memo.get(0).get(1).put(prices[0], dfs(prices[0], 0, 1, 1, prices, memo));

        // disp(prices, memo);

        return Math.max(
            memo.get(0).get(0).get(0),
            memo.get(0).get(1).get(prices[0])
        );
    }

    private int dfs(int holding, int profit, int state, int i, int[] prices, List<List<HashMap<Integer, Integer>>> memo) {
        if (i >= prices.length) {
            return profit;
        }

        if (memo.get(i).get(state).containsKey(holding)) {
            return profit + memo.get(i).get(state).get(holding);
        }

        if (state == 0) {
            int x = Math.max(
                dfs(0, profit, 0, i + 1, prices, memo),
                dfs(prices[i], profit, 1, i + 1, prices, memo)
            );

            memo.get(i).get(state).put(holding, x);

            return x;
        } else if (state == 1) {
            int x = Math.max(
                dfs(0, profit + prices[i] - holding, 2, i + 1, prices, memo),
                dfs(holding, profit, 1, i + 1, prices, memo)
            );

            memo.get(i).get(state).put(holding, x);

            return x;
        } else {
            int x = dfs(0, profit, 0, i + 1, prices, memo);

            memo.get(i).get(state).put(holding, x);

            return x;
        }
    }

    private void disp(int[] prices, List<List<HashMap<Integer, Integer>>> table) {
        for (int i = 0; i < table.size(); i++) {
            System.out.printf("%d: ", prices[i]);

            for (int holding : table.get(i).get(0).keySet()) {
                System.out.printf("(%d, %d), ", holding, table.get(i).get(0).get(holding));
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < table.size(); i++) {
            System.out.printf("%d: ", prices[i]);

            for (int holding : table.get(i).get(1).keySet()) {
                System.out.printf("(%d, %d), ", holding, table.get(i).get(1).get(holding));
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < table.size(); i++) {
            System.out.printf("%d: ", prices[i]);

            for (int holding : table.get(i).get(2).keySet()) {
                System.out.printf("(%d, %d), ", holding, table.get(i).get(2).get(holding));
            }

            System.out.println();
        }
    }
}
