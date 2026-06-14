class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        int[][] visited = new int[n][n];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        visited[0][0] = 1;
        pq.add(new Node(0, 0, grid[0][0]));

        int t = grid[0][0];
        while (true) {
            Node node = pq.remove();

            if (t < node.l) t = node.l;

            if (node.i == n - 1 && node.j == n - 1) break;
            
            int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            for (int[] direction : directions) {
                int x = node.i + direction[0];
                int y = node.j + direction[1];

                if (x < 0 || x >= n || y < 0 || y >= n) continue;

                if (visited[x][y] == 0) {
                    visited[node.i][node.j] = 1;
                    pq.add(new Node(x, y, grid[x][y]));
                }
            }
        }

        return t;
    }

    private class Node implements Comparable<Node> {
        public final int i;
        public final int j;
        public final int l;

        public Node(int i, int j, int l) {
            this.i = i;
            this.j = j;
            this.l = l;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.l, o.l);
        }
    }
}
