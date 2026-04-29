class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1 || grid[i][j] <= 0) continue;
                
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

        int[] costs = {
            dfs(grid, i - 1, j),
            dfs(grid, i, j - 1),
            dfs(grid, i + 1, j),
            dfs(grid, i, j + 1)
        };

        // System.out.println(i + ", " + j);
        // display(costs);

        int m = min(costs);

        if (m == 2147483647) {
            grid[i][j] = 2147483647;
        } else {
            grid[i][j] = 1 + m;
        }

        return grid[i][j];
    }

    private int min(int[] costs) {
        int min = Integer.MAX_VALUE;
        for (int c : costs) {
            if (c < min) min = c;
        }

        return min;
    }

    private void display(int[] costs) {
        for (int c : costs) System.out.print(c + ", ");
        System.out.println();
    }
}
