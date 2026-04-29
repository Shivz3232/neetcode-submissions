class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;

                int area = area(grid, i, j);
                if (area > result) {
                    result = area;
                }
            }
        }

        return result;
    }

    private int area(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return 0;
        if (grid[row][col] == 0) return 0;

        grid[row][col] = 0;

        int area = 1
            + area(grid, row - 1, col)
            + area(grid, row, col - 1)
            + area(grid, row + 1, col)
            + area(grid, row, col + 1);

        return area;
    }
}
