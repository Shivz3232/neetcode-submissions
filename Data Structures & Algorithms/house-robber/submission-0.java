class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int[] optimal_values = new int[nums.length];

        optimal_values[0] = nums[0];
        optimal_values[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            optimal_values[i] = Math.max(
                optimal_values[i - 1],
                optimal_values[i - 2] + nums[i]
            );
        }

        return optimal_values[nums.length - 1];
    }
}
