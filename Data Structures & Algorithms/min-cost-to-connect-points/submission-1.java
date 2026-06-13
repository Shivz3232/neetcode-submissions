class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                adjMatrix[i][j] = Math.abs(
                    points[i][0] - points[j][0]
                ) + Math.abs(
                    points[i][1] - points[j][1]
                );
            }
        }

        int result = 0;

        // Prim's Algorithm
        Set<Integer> A = new HashSet<>();
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        A.add(0);
        for (int i = 1; i < n; i++)
            pq.add(new Vertex(i, adjMatrix[0][i]));

        while (!pq.isEmpty()) {
            Vertex v = pq.remove();

            if (A.contains(v.id)) continue;

            A.add(v.id);
            result += v.key;

            // All points with id < v.id
            for (int i = 0; i < v.id; i++)
                if (!A.contains(i))
                    pq.add(new Vertex(i, adjMatrix[i][v.id]));
            
            // All points with id > v.id
            for (int i = v.id + 1; i < n; i++)
                if (!A.contains(i))
                    pq.add(new Vertex(i, adjMatrix[v.id][i]));
        }

        return result;
    }

    private class Vertex implements Comparable<Vertex> {
        public final int id;
        public final int key;

        public Vertex(int id, int key) {
            this.id = id;
            this.key = key;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.key, o.key);
        }
    }
}
