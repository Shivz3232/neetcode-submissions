class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++)
            nodes[i] = new Node();
        
        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];

            nodes[u].edges.add(new Edge(v, w));
        }

        dfs(k - 1, 0, nodes);

        // for (Node node : nodes)
        //     System.out.print(node.seenAt + ", ");
        // System.out.println();

        int result = 0;
        for (Node node : nodes) {
            if (!node.seen) return -1;
            
            if (node.seenAt > result) {
                result = node.seenAt;
            }
        }

        return result;
    }

    private void dfs(int i, int time, Node[] nodes) {
        Node n = nodes[i];
        
        if (!n.seen || (n.seen && n.seenAt > time)) {
            n.seen = true;
            n.seenAt = time;

            for (Edge e : nodes[i].edges)
                dfs(e.i, time + e.w, nodes);
        }
    }

    class Node {
        public final List<Edge> edges;
        public boolean seen;
        public int seenAt;

        Node() {
            this.edges = new ArrayList<>();
            this.seen = false;
            this.seenAt = 0; // Initial value is invalid
        }
    }

    class Edge {
        public final int i;
        public final int w;

        Edge(int i, int w) {
            this.i = i;
            this.w = w;
        }
    }
}
