class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            aux(nums, i, memo);

            result = Math.max(
                result,
                memo[i]
            );
        }
        
        return result;
    }

    private int aux(int[] nums, int i, int[] memo) {
        if (i >= nums.length) return 0;
        if (memo[i] > 0) return memo[i];

        int result = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] <= nums[i]) continue;
            
            result = Math.max(
                result,
                aux(nums, j, memo)
            );
        }

        memo[i] = result + 1;

        return memo[i];
    }
}
