class Solution {
    public int findDuplicate(int[] nums) {
        int length = nums.length;

        int map = (int) Math.pow(2, length);

        int result = -1;
        for (int n : nums) {
            int mask = (int) Math.pow(2, n - 1);

            if ((map & mask) != 0) {
                result = n;
                break;
            }

            map |= mask;
        }

        return result;
    }
}
