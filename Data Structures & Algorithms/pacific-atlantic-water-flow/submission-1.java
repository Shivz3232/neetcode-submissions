class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int[][] memoA = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (memoA[i][j] != 0) continue;

                dfs(heights, i, j, Integer.MAX_VALUE, memoA, Destination.A);
            }
        }

        // display(memoA);

        int[][] memoP = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (memoP[i][j] != 0) continue;

                dfs(heights, i, j, Integer.MAX_VALUE, memoP, Destination.P);
            }
        }

        // display(memoP);
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (memoP[i][j] == 2 && memoA[i][j] == 2) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private boolean dfs(int[][] heights, int i, int j, int prev, int[][] memo, Destination d) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length) return false;

        if (memo[i][j] == -1) return false;
        if (memo[i][j] == 1) return false;
        if (heights[i][j] > prev) return false;
        if (memo[i][j] == 2) return true;

        if (d == Destination.A && (i == heights.length - 1 || j == heights[0].length - 1)) {
            memo[i][j] = 2;
            return true;
        } else if (d == Destination.P && (i == 0 || j == 0)) {
            memo[i][j] = 2;
            return true;
        }

        memo[i][j] = 1;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean b = false;
        for (int[] direction : directions) {
            b = b || dfs(heights, i + direction[0], j + direction[1], heights[i][j], memo, d);
        }

        if (b) {
            memo[i][j] = 2;
        } else {
            memo[i][j] = -1;
        }

        return b;
    }

    private void display(int[][] heights) {
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                System.out.print(heights[i][j] + ", ");
            }
            System.out.println();
        }
    }

    private static enum Destination {
        P,
        A
    }
}
