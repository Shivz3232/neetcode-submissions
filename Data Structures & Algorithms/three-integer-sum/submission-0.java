class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = nums.length - 1, k = i + 1;
            while (k < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    j--;
                } else if (sum < 0) {
                    k++;
                } else {
                    results.add(List.of(nums[i], nums[j], nums[k]));
                    k++;
                    j--;
                    while (k < j && nums[k] == nums[k - 1]) {
                        k++;
                    }
                }
            }
        }

        return results;
    }
}
