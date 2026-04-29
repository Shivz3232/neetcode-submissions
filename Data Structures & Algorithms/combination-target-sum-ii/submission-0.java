class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(candidates);

        subset.add(candidates[0]);
        combinationSum2(candidates, target, candidates[0], 1, subset, result);

        subset.remove(subset.size() - 1);
        for (int i = 1; i < candidates.length; i++) {
            if (candidates[i - 1] == candidates[i]) continue;
            else {
                combinationSum2(candidates, target, 0, i, subset, result);
                break;
            }
        }

        // combinationSum2(candidates, target, 0, 1, subset, result);

        return result;
    }

    private void combinationSum2(int[] candidates, int target, int sum, int i, List<Integer> subset, List<List<Integer>> result) {
        if (sum > target) {
            // System.out.println(subset);
            return;
        } else if (sum == target) {
            result.add(new ArrayList<>(subset));
        } else if (i < candidates.length) {
            subset.add(candidates[i]);
            combinationSum2(candidates, target, sum + candidates[i], i + 1, subset, result);

            subset.remove(subset.size() - 1);
            for (int j = i + 1; j < candidates.length; j++) {
                if (candidates[j - 1] == candidates[j]) continue;
                else {
                    combinationSum2(candidates, target, sum, j, subset, result);
                    break;
                }
            }
            // combinationSum2(candidates, target, sum, i + 1, subset, result);
        }
    }
}
