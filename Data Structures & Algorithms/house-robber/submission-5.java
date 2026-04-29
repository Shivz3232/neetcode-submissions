class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int[] optimal_values = new int[nums.length];
        int[] optimal_solution = new int[nums.length];

        optimal_values[0] = nums[0];
        optimal_solution[0] = 0;

        if (nums[0] > nums[1]) {
            optimal_values[1] = nums[0];
            optimal_solution[1] = 0;
        } else {
            optimal_values[1] = nums[1];
            optimal_solution[1] = 1;
        }


        for (int i = 2; i < nums.length; i++) {
            // optimal_values[i] = Math.max(
                int x = optimal_values[i - 1];
                int y = optimal_values[i - 2] + nums[i];
            // );

            if (x > y) {
                optimal_values[i] = x;
                optimal_solution[i] = i - 1;
            } else {
                optimal_values[i] = y;
                optimal_solution[i] = i;
            }
        }

        // System.out.println(Arrays.toString(optimal_values));
        // System.out.println(Arrays.toString(optimal_solution));

        return optimal_values[nums.length - 1];
    }
}
