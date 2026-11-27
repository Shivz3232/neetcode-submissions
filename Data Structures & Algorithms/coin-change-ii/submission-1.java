class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] memo = new int[amount + 1][n];
        boolean[][] seen = new boolean[amount + 1][n];

        return dfs(0, 0, amount, coins, memo, seen);
    }

    private int dfs(int curVal, int i, int target, int[] coins, int[][] memo, boolean[][] seen) {
        if (i >= coins.length) return 0;

        if (curVal == target) return 1;

        if (seen[curVal][i]) return memo[curVal][i];
        
        int result = dfs(curVal, i + 1, target, coins, memo, seen);

        if (curVal + coins[i] <= target) {
            result += dfs(curVal + coins[i], i, target, coins, memo, seen);
        }

        memo[curVal][i] = result;
        seen[curVal][i] = true;

        return result;
    }
}
