class Solution {
    public int rob(int[] nums) {
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int robbed = nums[i]
                            + recursive(nums, 0, i - 2)
                            + recursive(nums, i + 2, nums.length - 1);
            
            int skipped = recursive(nums, 0, i - 1)
                            + recursive(nums, i + 1, nums.length - 1);

            int chosen = Math.max(robbed, skipped);
            
            result = Math.max(result, chosen);
        }

        return result;
    }

    private int recursive(int[] nums, int i, int j) {
        int result = Integer.MIN_VALUE;

        if (i > j) {
            return result;
        } else if (i == j) {
            return nums[i];
        }

        for (int k = i; k <= j; k++) {
            int robbed = nums[k]
                            + recursive(nums, i, k - 2)
                            + recursive(nums, k + 2, j);
            
            int skipped = recursive(nums, i, k - 1)
                            + recursive(nums, k + 1, j);

            int chosen = Math.max(robbed, skipped);
            
            result = Math.max(result, chosen);
        }

        return result;
    }
}
