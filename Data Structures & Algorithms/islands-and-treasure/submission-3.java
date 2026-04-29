class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1 || grid[i][j] == 0) continue;
                
                grid[i][j] = dfs(grid, i, j);
            }
        }
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 2147483647;
        }

        if (grid[i][j] < 0) {
            return 2147483647;
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        if (grid[i][j] != 2147483647) {
            return grid[i][j];
        }

        grid[i][j] = -2;

        int m = dfs(grid, i - 1, j);

        int x;
        if ((x = dfs(grid, i, j - 1)) < m) m = x;
        if ((x = dfs(grid, i + 1, j)) < m) m = x;
        if ((x = dfs(grid, i, j + 1)) < m) m = x;

        if (m == 2147483647) {
            grid[i][j] = m;
        } else {
            grid[i][j] = 1 + m;
        }

        return grid[i][j];
    }
}
