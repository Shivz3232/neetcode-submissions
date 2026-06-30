class Solution {
    public int missingNumber(int[] nums) {
        int x = 0;
        
        for (int n : nums) x ^= n;
        for (int i = 0; i <= nums.length; i++) {
            x ^= i;
        }

        return x;
    }
}
