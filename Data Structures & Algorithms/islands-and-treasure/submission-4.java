class Solution {
    private final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public void islandsAndTreasure(int[][] grid) {
        Queue<Qe> q = new LinkedList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) continue;

                for (int[] d : directions) {
                    q.add(new Qe(i + d[0], j + d[1], 1));
                }

                while (!q.isEmpty()) {
                    Qe qe = q.remove();

                    if (invalidIdx(grid, qe.i, qe.j)) continue;
                    if (grid[qe.i][qe.j] == -1) continue;
                    if (grid[qe.i][qe.j] == 0) continue;
                    if (qe.val >= grid[qe.i][qe.j]) continue;

                    grid[qe.i][qe.j] = qe.val;

                    for (int[] d : directions) {
                        q.add(new Qe(qe.i + d[0], qe.j + d[1], qe.val + 1));
                    }
                }
            }
        }
    }

    private boolean invalidIdx(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return true;
        }

        return false;
    }

    private static class Qe {
        public final int i;
        public final int j;
        public final int val;

        Qe(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
}
