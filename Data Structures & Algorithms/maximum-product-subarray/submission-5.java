class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[][] memo = new int[nums.length][nums.length];
        int[][] products = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i][i] = nums[i];
            products[i][i] = nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int product = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                product *= nums[j];
                products[i][j] = product;
            }
        }

        for (int l = 1; l < nums.length; l++) {
            for (int i = 0; i < nums.length - l; i++) {
                int j = i + l;

                memo[i][j] = Math.max(
                    products[i][j],
                    Math.max(
                        memo[i][j - 1],
                        memo[i + 1][j]
                    )
                );
            }
        }

        // displayMemo(products, nums.length);
        // System.out.println();
        // System.out.println();
        // System.out.println();
        // displayMemo(memo, nums.length);

        return memo[0][nums.length - 1];
    }

    private void displayMemo(int[][] memo, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (memo[i][j] == Integer.MIN_VALUE) {
                    System.out.print("X, ");
                } else {
                    System.out.print(memo[i][j] + ", ");
                }
            }
            System.out.println();
        }
    }
}
