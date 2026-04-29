class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : nums) {
            hashSet.add(i);
        }

        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.contains(nums[i] - 1)) {
                continue;
            }

            // System.out.println("here for " + nums[i]);

            int temp = 1;
            int cur = nums[i];
            while (hashSet.contains(cur - 1)) {
                // System.out.println(cur);
                cur--;
                temp++;
            }

            if (temp > result) {
                result = temp;
            }
        }

        return result;
    }
}
