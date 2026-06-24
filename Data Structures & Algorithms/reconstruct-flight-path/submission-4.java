class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Node> adjList = new HashMap<>();

        for (List<String> ticket : tickets) {
            String source = ticket.get(0);
            String destination = ticket.get(1);

            Node sourceN = adjList.computeIfAbsent(source, (s) -> new Node(s));
            sourceN.neighbors.add(
                adjList.computeIfAbsent(destination, (d) -> new Node(d))
            );
        }

        for (String key : adjList.keySet())
            Collections.sort(adjList.get(key).neighbors);

        List<String> result = new ArrayList<>();
        result.add("JFK");
        
        dfs("JFK", adjList, result);

        return result;
    }

    public void dfs(String source, Map<String, Node> adjList, List<String> result) {
        Node sourceN = adjList.get(source);

        if (sourceN.explored == sourceN.neighbors.size()) return;

        Node next = sourceN.neighbors.get(sourceN.explored);
        result.add(next.key);
        
        sourceN.explored += 1;

        dfs(next.key, adjList, result);
    }

    private class Node implements Comparable<Node> {
        public final String key;
        public final List<Node> neighbors;
        public int explored;

        public Node(String key) {
            this.key = key;
            this.neighbors = new ArrayList<>();
            this.explored = 0;
        }

        @Override
        public int compareTo(Node o) {
            int a = this.neighbors.size();
            int b = o.neighbors.size();
            if (a > b) {
                return -1;
            } else if (a == b) {
                return this.key.compareTo(o.key);
            } else {
                return 1;
            }
        }
    }
}
