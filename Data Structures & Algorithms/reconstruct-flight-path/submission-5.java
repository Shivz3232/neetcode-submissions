class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Node> adjList = new HashMap<>();

        for (List<String> ticket : tickets) {
            String source = ticket.get(0);
            String destination = ticket.get(1);

            Node sourceN = adjList.computeIfAbsent(source, (s) -> new Node(s));
            sourceN.neighbors.add(destination);

            adjList.putIfAbsent(destination, new Node(destination));
        }

        for (String key : adjList.keySet()) {
            Node n = adjList.get(key);
            n.explored = new int[n.neighbors.size()];
            Collections.sort(n.neighbors);
        }

        List<String> result = new ArrayList<>();
        result.add("JFK");
        
        dfs("JFK", adjList, result, 0, tickets.size());

        return result;
    }

    public boolean dfs(String src, Map<String, Node> adjList, List<String> result, int consumed, int total) {        
        Node srcN = adjList.get(src);

        int nNeighbors = srcN.neighbors.size();

        if (nNeighbors == 0 || srcN.nExplored == nNeighbors)
            return consumed == total;

        for (int i = 0; i < nNeighbors; i++) {
            if (srcN.explored[i] == 1) continue;

            String next = srcN.neighbors.get(i);

            srcN.explored[i] = 1;
            srcN.nExplored += 1;
            result.add(next);

            if (dfs(next, adjList, result, consumed + 1, total)) return true;

            result.remove(result.size() - 1);
            srcN.nExplored -= 1;
            srcN.explored[i] = 0;
        }

        return false;
    }

    private class Node {
        public final String key;
        public final List<String> neighbors;
        public int[] explored;
        public int nExplored;

        public Node(String key) {
            this.key = key;
            this.nExplored = 0;
            this.neighbors = new ArrayList<>();
        }
    }
}
