class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        int[] solution = new int[nums.length];
        
        int result = 0;
        int resultI = 0;
        for (int i = 0; i < nums.length; i++) {
            aux(nums, i, memo, solution);

            if (memo[i] > result) {
                result = memo[i];
                resultI = i;
            }
        }

        // for (int i = resultI; i < nums.length; i = solution[i]) {
        //     System.out.print(nums[i] + ", ");
        // }
        // System.out.println();
        
        return result;
    }

    private void aux(int[] nums, int i, int[] memo, int[] solution) {
        if (i >= nums.length || memo[i] > 0) return;

        int result = 0;
        int nextI = nums.length;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] <= nums[i]) continue;

            aux(nums, j, memo, solution);

            if (memo[j] > result) {
                result = memo[j];
                nextI = j;
            }
        }

        memo[i] = result + 1;
        solution[i] = nextI;
    }
}
