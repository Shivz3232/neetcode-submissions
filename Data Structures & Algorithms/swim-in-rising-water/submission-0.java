class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int[][] visited = new int[n][n];
        int[] waterLevel = new int[1];

        int[] result = new int[1];
        result[0] = -1;

        dfs(0, 0, waterLevel, visited, grid, result, n);

        return result[0];
    }

    private void dfs(int i, int j, int[] waterLevel, 
                        int[][] visited, int[][] grid, int[] result, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n) return;

        if (visited[i][j] == 1) return;

        int initialWaterLevel = waterLevel[0];

        if (grid[i][j] > waterLevel[0]) {
            waterLevel[0] = grid[i][j];
        }

        if (i == n - 1 && j == n - 1) {

            // System.out.println("Result: " + result[0]);
            // System.out.println("WaterLevel: " + waterLevel[0]);
            // printMatrix(visited, n);
            // System.out.println();
            if (result[0] == -1) {
                result[0] = waterLevel[0];
            } else if (waterLevel[0] < result[0]) {
                result[0] = waterLevel[0];
            }

            waterLevel[0] = initialWaterLevel;

            return;
        }

        visited[i][j] = 1;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] direction : directions) {
            dfs(
                i + direction[0],
                j + direction[1],
                waterLevel,
                visited,
                grid,
                result,
                n
            );
        }

        visited[i][j] = 0;

        waterLevel[0] = initialWaterLevel;
    }

    private void printMatrix(int[][] m, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("| ");
            for (int j = 0; j < n - 1; j++) {
                System.out.print(m[i][j] + " | ");
            }
            System.out.println(m[i][n - 1] + " |");
        }
    }
}
