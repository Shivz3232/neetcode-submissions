class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] board = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) board[i][j] = -1;
                else if (grid[i][j] == 1) board[i][j] = -2;
                else board[i][j] = 0;
            }
        }

        Queue<Index> q = new LinkedList<>();

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 2) continue;
                if (board[i][j] != 0) continue;

                // System.out.println(i + ", " + j);
                // display(board);
                // System.out.println();

                for (int[] d : directions) {
                    q.add(new Index(i + d[0], j + d[1], 1));
                }

                while (!q.isEmpty()) {
                    Index idx = q.remove();
                    
                    if (invalidIdx(grid, idx.i, idx.j)) continue;
                    if (board[idx.i][idx.j] == 0) continue;

                    if (board[idx.i][idx.j] == -2 || board[idx.i][idx.j] > idx.minute) {
                        board[idx.i][idx.j] = idx.minute;

                        for (int[] d : directions) {
                        q.add(new Index(idx.i + d[0], idx.j + d[1], idx.minute + 1));
                    }
                    }
                }
            }
        }

        // display(board);

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (board[i][j] == -2) return -1;
                if (board[i][j] > max) max = board[i][j];
            }
        }

        return max;
    }

    private boolean invalidIdx(int[][] grid, int i, int j) {
        return i < 0 || i >= grid.length || j < 0 || j >= grid[0].length;
    }

    private void display(int[][] grid) {
        for (int[] row : grid) {
            for (int i : row) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }

    private static class Index {
        public final int i;
        public final int j;
        public final int minute;

        Index(int i, int j, int minute) {
            this.i = i;
            this.j = j;
            this.minute = minute;
        }
    }
}
