class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        boolean zeroPresent = false;

        int result = Integer.MIN_VALUE;
        int product = 1;

        boolean open = false;
        int i = -1, j;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == 0) zeroPresent = true;
            
            if (!open) {
                if (nums[k] == 0) continue;
                else {
                    i = k;
                    product = nums[k];
                    open = true;
                }
            } else {
                if (nums[k] == 0) {
                    j = k - 1;
                    open = false;

                    result = Math.max(
                        result,
                        Math.max(
                            product,
                            Math.max(
                                aux(nums, i + 1, j, product / nums[i]),
                                aux(nums, i, j - 1, product / nums[j])
                            )
                        )
                    );
                } else {
                    product *= nums[k];
                }
            }
        }

        if (open) {
            result = Math.max(
                result,
                Math.max(
                    product,
                    Math.max(
                        aux(nums, i + 1, nums.length - 1, product / nums[i]),
                        aux(nums, i, nums.length - 2, product / nums[nums.length - 1])
                    )
                )
            );
        }

        if (result < 0 && zeroPresent) {
            return 0;
        } else {
            return result;
        }
    }

    private int aux(int[] nums, int i, int j, int product) {
        if (j < i) {
            return 0;
        } else if (i == j) {
            return nums[i];
        } else {
            return Math.max(
                aux(nums, i + 1, j, product / nums[i]),
                aux(nums, i, j - 1, product / nums[j])
            );
        }
    }
}
