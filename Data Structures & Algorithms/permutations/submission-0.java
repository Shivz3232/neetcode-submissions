class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();

        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            seen.add(i);
            permutation.add(nums[i]);
            
            permute(nums, seen, permutation, result);

            seen.remove(i);
            permutation.remove(permutation.size() - 1);
        }

        return result;
    }

    private void permute(int[] nums, Set<Integer> seen, List<Integer> permutation, List<List<Integer>> result) {
        if (seen.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
        } else {
            for (int j = 0; j < nums.length; j++) {
                if (seen.contains(j)) continue;

                seen.add(j);
                permutation.add(nums[j]);

                permute(nums, seen, permutation, result);

                seen.remove(j);
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
