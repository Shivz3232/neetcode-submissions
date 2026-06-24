class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Node> adjList = new HashMap<>();

        for (List<String> ticket : tickets) {
            String source = ticket.get(0);
            String destination = ticket.get(1);

            Node sourceN = adjList.computeIfAbsent(source, (s) -> new Node(s));
            sourceN.neighbors.add(destination);
            
            adjList.computeIfAbsent(destination, (d) -> new Node(d));
        }

        for (String key : adjList.keySet())
            Collections.sort(adjList.get(key).neighbors);

        // displayAdjList(adjList);

        List<String> result = new ArrayList<>();

        dfs("JFK", adjList, result);

        return result;
    }

    private void dfs(String source, Map<String, Node> adjList, List<String> result) {
        result.add(source);

        Node sourceN = adjList.get(source);

        if (sourceN.s != Node.Status.WHITE) return;

        sourceN.s = Node.Status.GRAY;

        for (String neighbor : sourceN.neighbors)
            dfs(neighbor, adjList, result);

        sourceN.s = Node.Status.BLACK;
    }

    private void displayAdjList(Map<String, Node> adjList) {
        for (String key : adjList.keySet()) {
            Node n = adjList.get(key);
            System.out.print(key + ": ");
            for (String x : n.neighbors) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private class Node {
        public final String key;
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
