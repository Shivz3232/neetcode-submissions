class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) return false;

        int[] picked = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            picked[i] = 1;
            
            if (aux(nums, nums[i], 0, picked, 1)) {
                return true;
            }

            picked[i] = 0;
        }

        return false;
    }

    private boolean aux(int[] nums, int sum1, int sum2, int[] picked, int pickedCount) {
        if (pickedCount == nums.length) return sum1 == sum2;

        for (int i = 0; i < nums.length; i++) {
            if (picked[i] == 1) continue;
            
            picked[i] = 1;
            if (sum1 < sum2) {
                if (aux(nums, sum1 + nums[i], sum2, picked, pickedCount + 1)) {
                    return true;
                }
            } else {
                if (aux(nums, sum1, sum2 + nums[i], picked, pickedCount + 1)) {
                    return true;
                }
            }
            picked[i] = 0;
        }

        return false;
    }
}
