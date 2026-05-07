class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(
                result,
                aux(nums, nums[i], i, 1)
            );
        }
        
        return result;
    }

    private int aux(int[] nums, int num, int i, int c) {
        if (i >= nums.length) return c;

        int result = c;
        for (int j = i; j < nums.length; j++) {
            if (nums[j] <= num) continue;
            
            result = Math.max(
                result,
                aux(nums, nums[j], j + 1, c + 1)
            );
        }

        return result;
    }
}
