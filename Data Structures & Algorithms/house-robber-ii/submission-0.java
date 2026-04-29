class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        return Math.max(rob0(nums), rob1(nums));
    }

    private int rob0(int[] nums) {
        int[] optimal_values = new int[nums.length];

        optimal_values[0] = nums[0];
        optimal_values[1] = nums[0];

        for (int i = 2; i < nums.length - 1; i++) {
            int x = optimal_values[i - 1];
            int y = optimal_values[i - 2] + nums[i];

            optimal_values[i] = Math.max(x, y);
        }

        // Copy n - 1 value to n as we don't compute nth
        optimal_values[nums.length - 1] = optimal_values[nums.length - 2];

        return optimal_values[nums.length - 1];
    }

    private int rob1(int[] nums) {
        int[] optimal_values = new int[nums.length];

        optimal_values[0] = 0;
        optimal_values[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            int x = optimal_values[i - 1];
            int y = optimal_values[i - 2] + nums[i];

            optimal_values[i] = Math.max(x, y);
        }

        return optimal_values[nums.length - 1];
    }
}
