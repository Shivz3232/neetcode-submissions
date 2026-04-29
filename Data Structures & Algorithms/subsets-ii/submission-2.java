class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of());

        List<Integer> subset = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            subset.add(nums[i]);
            subsetsWithDup(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }

        // subset.add(nums[nums.length - 1]);
        // subsetsWithDup(nums, nums.length, subset, result);
        // subset.remove(subset.size() - 1);

        return result;
    }

    private void subsetsWithDup(int[] nums, int i, List<Integer> subset, List<List<Integer>> result) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        } else {

            subset.add(nums[i]);
            subsetsWithDup(nums, i + 1, subset, result);

            int j = i + 1;
            for (; j < nums.length && nums[j] == nums[j - 1]; j++)

            subset.remove(subset.size() - 1);
            subsetsWithDup(nums, j, subset, result);
        }
    }
}
