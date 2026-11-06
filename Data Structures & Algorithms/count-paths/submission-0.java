class Solution {
    public int uniquePaths(int n, int m) {
        int[][] memo = new int[n][m];

        memo[n - 1][m - 1] = 1;

        // Lower right half
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i && j < n; j++) {
                int x = n - j - 1;
                int y = m - i + j - 1;

                if (x == n - 1 || y == m - 1) {
                    memo[x][y] = 1;
                } else {
                    memo[x][y] = memo[x + 1][y] + memo[x][y + 1];
                }
            }
        }

        // TODO: Upper left half
        for (int i = 0; i < n - 1; i++) {
            System.out.println(i);
            for (int j = 0; j < n - 1 - i; j++) {
                int x = n - 2 - i - j;
                int y = j;

                // System.out.printf("(%d, %d)\n", x, y);

                memo[x][y] = memo[x + 1][y] + memo[x][y + 1];
            }   
        }

        return memo[0][0];
    }

    private void disp(int n, int m, int[][] table) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d, ", table[i][j]);
            }
            System.out.println();
        }
    }
}
