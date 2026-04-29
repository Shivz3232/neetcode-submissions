class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length + 1];

        for (int i = 2; i <= cost.length; i++) {
            result[i] = Math.min(
                result[i - 1] + cost[i - 1],
                result[i - 2] + cost[i - 2]
            );
        }

        return result[cost.length];
    }
}
