class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            if (adjList.containsKey(u)) {
                adjList.get(u).add(v);
            } else {
                List<Integer> neghibours = new ArrayList<>();
                neghibours.add(v);
                
                adjList.put(u, neghibours);
            }

            if (adjList.containsKey(v)) {
                adjList.get(v).add(u);
            } else {
                List<Integer> neghibours = new ArrayList<>();
                neghibours.add(u);
                
                adjList.put(v, neghibours);
            }
        }

        Set<Integer> visited = new HashSet<>();

        if (!dfs(0, -1, adjList, visited)) {
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
