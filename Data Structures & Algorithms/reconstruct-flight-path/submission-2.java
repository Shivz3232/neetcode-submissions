class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Node> adjList = new HashMap<>();

        for (List<String> ticket : tickets) {
            String source = ticket.get(0);
            String destination = ticket.get(1);

            Node sourceN = adjList.computeIfAbsent(source, (s) -> new Node(s));
            sourceN.outDegree += 1;

            Node destinationN = adjList.computeIfAbsent(destination, (d) -> new Node(d));
            destinationN.inDegree += 1;

            sourceN.neighbors.add(destinationN);
        }

        for (String key : adjList.keySet())
            Collections.sort(adjList.get(key).neighbors);

        List<String> result = new ArrayList<>();

        dfs("JFK", adjList, result);

        return result;
    }

    private void dfs(String source, Map<String, Node> adjList, List<String> result) {
        result.add(source);

        Node sourceN = adjList.get(source);

        if (sourceN.s != Node.Status.WHITE) return;

        sourceN.s = Node.Status.GRAY;

        for (Node neighbor : sourceN.neighbors)
            dfs(neighbor.key, adjList, result);

        sourceN.s = Node.Status.BLACK;
    }

    private class Node implements Comparable<Node> {
        public final String key;
        public Status s;
        public int outDegree;
        public int inDegree;
        public final List<Node> neighbors;
        private static final Comparator<String> stringComparator = Comparator.naturalOrder();

        public Node(String key) {
            this.key = key;
            this.s = Status.WHITE;
            this.outDegree = 0;
            this.inDegree = 0;
            this.neighbors = new ArrayList<>();
        }

        @Override
        public int compareTo(Node o) {
            if (this.outDegree == o.outDegree) {
                return stringComparator.compare(this.key, o.key);
            } else if (this.outDegree > o.outDegree) {
                return -1;
            } else {
                return 1;
            }
        }

        enum Status {
            WHITE,
            GRAY,
            BLACK
        }
    }
}
