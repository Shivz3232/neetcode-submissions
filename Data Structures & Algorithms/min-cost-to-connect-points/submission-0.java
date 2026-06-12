class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges.add(new Edge(i, j, points));
            }
        }

        Collections.sort(edges);

        // Kruskal's Algorithm
        DisjointSet dj = new DisjointSet(points.length);

        int n = 0;
        int result = 0;
        for (Edge edge : edges) {
            if (dj.union(edge.parent, edge.child)) {
                n += 1;
                result += edge.distance;
            }

            if (n == points.length) break;
        }

        return result;
    }

    private class Edge implements Comparable<Edge> {
        public final int parent;
        public final int child;
        public final int distance;

        public Edge(int parent, int child, int[][] points) {
            this.parent = parent;
            this.child = child;
            this.distance = Math.abs(
                points[parent][0] - points[child][0]
            ) + Math.abs(
                points[parent][1] - points[child][1]
            );
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(distance, o.distance);
        }
    }

    private class DisjointSet {
        private final int[] parent;
        private final int[] size;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }

            parent[i] = find(parent[i]);

            return parent[i];
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI == rootJ) {
                return false; 
            }

            if (size[rootI] < size[rootJ]) {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            } else {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            }

            return true;
        }
    }
}
