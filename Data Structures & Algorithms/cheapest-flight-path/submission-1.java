class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Node> adjList = new HashMap<>();

        for (int i = 0; i < n; i++)
            adjList.put(i, new Node(i));
        
        for (int[] flight : flights) {
            int source = flight[0];
            int dest = flight[1];
            int cost = flight[2];

            adjList.get(source).edges.add(
                new Edge(dest, cost)
            );
        }

        PriorityQueue<Ele> pq = new PriorityQueue<>();

        Node srcN = adjList.get(src);
        for (Edge e : srcN.edges) {
            pq.add(new Ele(e.dest, e.cost, 0));
        }

        int result = -1;
        while (!pq.isEmpty()) {
            Ele ele = pq.remove();

            if (ele.nHops > k) {
                continue;
            }

            if (ele.i == dst) {
                result = ele.cost;
                break;
            }

            for (Edge e : adjList.get(ele.i).edges) {
                pq.add(new Ele(e.dest, ele.cost + e.cost, ele.nHops + 1));
            }
        }

        return result;
    }

    public class Node {
        public final int i;
        public boolean visited;
        public final List<Edge> edges;

        public Node(int i) {
            this.i = i;
            visited = false;
            this.edges = new ArrayList<>();
        }
    }

    public class Edge{
        public final int dest;
        public final int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public class Ele implements Comparable<Ele> {
        public final int i;
        public final int nHops;
        public final int cost;

        public Ele(int i, int cost, int nHops) {
            this.i = i;
            this.nHops = nHops;
            this.cost = cost;
        }

        @Override
        public int compareTo(Ele o) {
            return Integer.compare(this.cost, o.cost);
            // if (this.nHops < o.nHops) {
            //     return -1;
            // } else if (this.nHops == o.nHops) {
            // } else {
            //     return 1;
            // }
        }
    }
}
