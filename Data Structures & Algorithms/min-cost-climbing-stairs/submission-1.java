class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int x = 0;
        int y = 0;
        // int result = 0;

        for (int i = 2; i <= cost.length; i++) {
            int t = y;
            
            y = Math.min(
                x + cost[i - 2],
                y + cost[i - 1]
            );

            x = t;
        }

        return y;
    }
}
