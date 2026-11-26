class Solution {
    public int change(int amount, int[] coins) {
        int[] soln = new int[1];

        dfs(0, 0, amount, coins, soln);

        return soln[0];
    }

    private void dfs(int curVal, int i, int target, int[] coins, int[] soln) {
        if (curVal > target) return;

        if (curVal == target) {
            soln[0] += 1;

            return;
        }

        for (int j = i; j < coins.length; j++) {
            dfs(curVal + coins[j], j, target, coins, soln);
        }
    }
}
