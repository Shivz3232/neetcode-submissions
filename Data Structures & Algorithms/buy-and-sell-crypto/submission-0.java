class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int boughtOn = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[boughtOn]) {
                boughtOn = i;
            } else {
                int diff = prices[i] - prices[boughtOn];
                if (diff > profit) {
                    profit = diff;
                }
            }
        }

        return profit;
    }
}
