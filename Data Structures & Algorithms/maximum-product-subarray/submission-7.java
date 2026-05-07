class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int zeroCount = 0;

        int result = Integer.MIN_VALUE;
        
        boolean split = false;
        int splitI = -1;
        int x = 1, y = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;

                result = Math.max(result, y);

                if (split) {
                    result = Math.max(
                        result,
                        Math.max(
                            x,
                            y
                        )
                    );

                    split = false;
                    y = 1;
                    x = 1;
                } else {
                    result = Math.max(result, y);
                    y = 1;
                }
            } else if (nums[i] < 0) {
                if (split) {
                    // Merge
                    y *= x * nums[splitI] * nums[i];
                    split = false;
                } else {
                    x = y;
                    splitI = i;
                    y = 1;

                    split = true;
                }
            } else {
                y *= nums[i];
            }
        }

        if (split) {
            result = Math.max(
                result,
                Math.max(
                    x,
                    y
                )
            );
        } else {
            result = Math.max(result, y);
        }

        if (zeroCount == nums.length) {
            return 0;
        }

        if (zeroCount > 0 && result < 0) {
            return 0;
        } else {
            return result;
        }
    }
}
