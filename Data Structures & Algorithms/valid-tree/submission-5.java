class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        Set<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, adjList, visited)) {
            return false;
        }

        if (visited.size() != n) {
            return false;
        }

        return true;
    }

    private boolean dfs(int i, int parent, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        if (visited.contains(i)) return false;

        visited.add(i);
        for (int neghibour : adjList.get(i)) {
            if (neghibour == parent) continue;

            if (!dfs(neghibour, i, adjList, visited)) {
                return false;
            }
        }
        
        return true;
    }
}
