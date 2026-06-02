class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Node[] adjList = new Node[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new Node();
        
        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];

            adjList[u].edges.add(new Edge(v, w));
        }

        dijkstra(k - 1, n, adjList);

        int result = 0;
        for (Node node : adjList) {
            // if (!node.seen) return -1;
            if (node.seenAt == Integer.MAX_VALUE) return -1;
            
            if (node.seenAt > result) {
                result = node.seenAt;
            }
        }

        return result;
    }

    private void dijkstra(int source, int n, Node[] adjList) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // Initialize Single Source
        adjList[source].seenAt = 0;
        for (Node node : adjList)
            pq.add(node);

        while (!pq.isEmpty()) {
            Node node = pq.remove();

            // Will skip deprecated entries
            // if (node.seen) continue;

            for (Edge edge : node.edges) {
                Node neighbor = adjList[edge.neighborI];

                int newSeenAt = node.seenAt + edge.weight;
                if (newSeenAt < neighbor.seenAt) {
                    // Relax
                    neighbor.seenAt = newSeenAt;

                    pq.add(neighbor);
                }
            }
        }
    }

    class Node implements Comparable<Node> {
        public final List<Edge> edges;
        public boolean seen;
        public int seenAt;

        Node() {
            this.edges = new ArrayList<>();
            this.seen = false;
            this.seenAt = Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(seenAt, o.seenAt);
        }
    }

    class Edge {
        public final int neighborI;
        public final int weight;

        Edge(int neighborI, int weight) {
            this.neighborI = neighborI;
            this.weight = weight;
        }
    }
}
