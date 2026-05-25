class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] memoP = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) memoP[i][0] = 1;
        for (int i = 0; i < heights[0].length; i++) memoP[0][i] = 1;

        for (int i = 0; i < heights.length; i++)
            for (int[] direction : directions)
                dfs(i + direction[0], 0 + direction[1], heights[i][0], heights, memoP);
        
        for (int i = 0; i < heights[0].length - 1; i++)
            for (int[] direction : directions)
                dfs(0 + direction[0], i + direction[1], heights[0][i], heights, memoP);

        // display(memoP);

        int[][] memoA = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) memoA[i][heights[0].length - 1] = 1;
        for (int i = 0; i < heights[0].length; i++) memoA[heights.length - 1][i] = 1;

        for (int i = 0; i < heights.length; i++)
            for (int[] direction : directions)
                dfs(i + direction[0], heights[0].length - 1 + direction[1], heights[i][heights[0].length - 1], heights, memoA);
        
        for (int i = 0; i < heights[0].length - 1; i++)
            for (int[] direction : directions)
                dfs(heights.length - 1 + direction[0], i + direction[1], heights[heights.length - 1][i], heights, memoA);

        // System.out.println();
        // display(memoA);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++)
            for (int j = 0; j < heights[0].length; j++)
                if (memoP[i][j] == 1 && memoA[i][j] == 1)
                    result.add(List.of(i, j));
        
        return result;
    }

    private void dfs(int i, int j, int prevH, int[][] heights, int[][] memo) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length) return;
        if (memo[i][j] != 0) return;
        if (heights[i][j] < prevH) return;

        memo[i][j] = 1;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] direction : directions)
            dfs(i + direction[0], j + direction[1], heights[i][j], heights, memo);
    }

    private void display(int[][] memo) {
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                System.out.print(memo[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
