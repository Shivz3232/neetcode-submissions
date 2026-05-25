class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int[][] memoP = new int[heights.length][heights[0].length];
        int[][] memoA = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (memoA[i][j] != 0 && memoP[i][j] != 0) continue;

                dfs(heights, i, j, Integer.MAX_VALUE, memoA, memoP);
            }
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (memoP[i][j] == 2 && memoA[i][j] == 2) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private int[] dfs(int[][] heights, int i, int j, int prev, int[][] memoA, int[][] memoP) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length) return false;

        int[] result = new int[2];

        if (heights[i][j] > prev) return result;

        if (i == 0 || j == 0) {
            memoP[i][j] = 2;
            result[0] = 1;
        }

        if (i == heights.length - 1 || j == heights[0].length - 1) {
            memoA[i][j] = 2;
            result[1] = 1;
        }

        if (result[0] != 0 && result[1] != 0) return result;

        if (result[0] != 0) memoP[i][j] = 1;
        if (result[1] != 0) memoA[i][j] = 1;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] direction : directions) {
            int[] exploration = dfs(heights, i + direction[0], j + direction[1], heights[i][j], memoP, memoA)
        }

        // Resetting instead of -1,
        // Path may not be found due to encountering
        // neighbors that are under exploration.
        // Thus, path may be found later.
        memo[i][j] = 0;
        
        return false;
    }

    private void display(int[][] heights) {
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                System.out.print(heights[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
