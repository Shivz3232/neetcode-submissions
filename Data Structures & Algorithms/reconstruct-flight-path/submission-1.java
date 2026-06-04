class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Node> adjList = new HashMap<>();

        for (List<String> ticket : tickets) {
            String source = ticket.get(0);
            String destination = ticket.get(1);

            Node n = adjList.computeIfAbsent(source,
                (s) -> new Node(s)
            );
            n.neighbors.add(destination);

            adjList.computeIfAbsent(destination, (d) -> new Node(d));
        }

        for (String key : adjList.keySet())
            Collections.sort(adjList.get(key).neighbors);

        List<String> result = new ArrayList<>();

        // result.add("JFK");

        int[] time = {0};
        dfs("JFK", adjList, time, result);

        // displayTimes(adjList);

        return result;
    }

    private void dfs(String source, Map<String, Node> adjList, int[] time, List<String> result) {
        result.add(source);

        Node sourceN = adjList.get(source);

        if (sourceN.s != Node.Status.WHITE) return;

        sourceN.s = Node.Status.GRAY;
        sourceN.d = ++time[0];

        for (String neighbor : sourceN.neighbors)
            dfs(neighbor, adjList, time, result);

        sourceN.s = Node.Status.BLACK;
        sourceN.f = ++time[0];
    }

    private void displayTimes(Map<String, Node> adjList) {
        for (String key : adjList.keySet()) {
            Node n = adjList.get(key);
            System.out.println(key + ": " + n.d + ", " + n.f);
        }
    }

    private class Node {
        public final String key;
        public int d;
        public int f;
        public Status s;
        public final List<String> neighbors;

        public Node(String key) {
            this.key = key;
            this.s = Status.WHITE;
            this.neighbors = new ArrayList<>();
        }

        enum Status {
            WHITE,
            GRAY,
            BLACK
        }
    }
}
