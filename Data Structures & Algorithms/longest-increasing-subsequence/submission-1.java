class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(
                result,
                aux(nums, nums[i], i, 1, memo)
            );
        }
        
        return result;
    }

    private int aux(int[] nums, int num, int i, int c, int[] memo) {
        if (i >= nums.length) return c;
        if (memo[i] > 0) return memo[i];

        int result = c;
        for (int j = i; j < nums.length; j++) {
            if (nums[j] <= num) continue;
            
            result = Math.max(
                result,
                aux(nums, nums[j], j + 1, c + 1, memo)
            );
        }

        memo[i] = result;

        return result;
    }
}
