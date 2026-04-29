class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        subsetsWithDup(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void subsetsWithDup(int[] nums, int i, List<Integer> subset, List<List<Integer>> result) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        } else {
            subset.add(nums[i]);
            subsetsWithDup(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);

            for (; i + 1 < nums.length && nums[i] == nums[i + 1]; i++);

            subsetsWithDup(nums, i + 1, subset, result);
        }
    }
}
