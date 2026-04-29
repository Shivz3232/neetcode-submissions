class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int resultI = 0;
        int[] result = new int[nums.length - k + 1];

        int l = 0, r = k - 1;
        int maxI = -1;
        while (r < nums.length) {
            if (maxI < l) {
                maxI = l;
                for (int i = l; i <= r; i++) {
                    if (nums[i] > nums[maxI]) {
                        maxI = i;
                    }
                }
            } else {
                if (nums[r] >= nums[maxI]) {
                    maxI = r;
                }
            }

            result[resultI++] = nums[maxI];

            l++;
            r++;
        }

        return result;
    }
}
