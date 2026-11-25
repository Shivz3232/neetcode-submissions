class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] memo = new int[n][3];
        boolean[][] seen = new boolean[n][3];

        int a = dfs(n - 1, 0, prices, memo, seen);
        int b = dfs(n - 1, 1, prices, memo, seen);
        int c = dfs(n - 1, 2, prices, memo, seen);

        disp(n, memo, seen);

        return Math.max(
            a,
            Math.max(
                b,
                c   
            )
        );
    }

    private int dfs(int i, int state, int[] prices, int[][] memo, boolean[][] seen) {
        if (i < 0) return 0;

        if (seen[i][state]) return memo[i][state];

        if (state == 0) {
            memo[i][state] = Math.max(
                dfs(i - 1, 0, prices, memo, seen),
                dfs(i - 1, 2, prices, memo, seen)
            );
        } else if (state == 1) {
            memo[i][state] = Math.max(
                dfs(i - 1, 0, prices, memo, seen),
                dfs(i - 1, 1, prices, memo, seen)
            ) -  prices[i];
        } else {
            memo[i][state] = dfs(i - 1, 1, prices, memo, seen) + prices[i];
        }

        seen[i][state] = true;

        return memo[i][state];
    }

    private void disp(int n, int[][] memo, boolean[][] seen) {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d: ", i);
            for (int j = 0; j < n; j++) {
                if (seen[j][i]) {
                    System.out.printf("%d, ", memo[j][i]);
                } else {
                    System.out.printf("X, ");
                }
            }
            System.out.println();
        }
    }
}
