class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        subset.add(nums[0]);
        combinationSum(nums, 0, target, nums[0], subset, result);

        subset.remove(subset.size() - 1);
        combinationSum(nums, 1, target, 0, subset, result);
        
        return result;
    }

    public void combinationSum(int[] nums, int i, int target, int sum, List<Integer> subset, List<List<Integer>> result) {
        if (sum > target || i >= nums.length) {
            // System.out.println(subset);
            return;
        } else if (sum == target) {
            result.add(new ArrayList<>(subset));
        } else {
            subset.add(nums[i]);
            combinationSum(nums, i, target, sum + nums[i], subset, result);

            subset.remove(subset.size() - 1);
            combinationSum(nums, i + 1, target, sum, subset, result);
        }
    }
}
