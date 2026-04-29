class Solution {
    public int rob(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                memo[i][j] = Integer.MIN_VALUE;
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int robbed = nums[i]
                            + recursive(nums, 0, i - 2, memo)
                            + recursive(nums, i + 2, nums.length - 1, memo);
            
            int skipped = recursive(nums, 0, i - 1, memo)
                            + recursive(nums, i + 1, nums.length - 1, memo);

            int chosen = Math.max(robbed, skipped);
            
            result = Math.max(result, chosen);
        }

        return result;
    }

    private int recursive(int[] nums, int i, int j, int[][] memo) {
        int result = Integer.MIN_VALUE;

        if (i > j) {
            return result;
        } else if (memo[i][j] == -1) {
            return result;
        } else if (memo[i][j] >= 0) {
            return memo[i][j];
        }

        if (i == j) {
            memo[i][j] = nums[i];
            return nums[i];
        }

        for (int k = i; k <= j; k++) {
            int robbed = nums[k]
                            + recursive(nums, i, k - 2, memo)
                            + recursive(nums, k + 2, j, memo);
            
            int skipped = recursive(nums, i, k - 1, memo)
                            + recursive(nums, k + 1, j, memo);

            int chosen = Math.max(robbed, skipped);
            
            result = Math.max(result, chosen);
        }

        memo[i][j] = result == Integer.MIN_VALUE ? -1 : result;

        return result;
    }
}
