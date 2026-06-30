class Solution {
    public int missingNumber(int[] nums) {
        int next = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != next) return next;
            next += 1;
        }

        return next;
    }
}
