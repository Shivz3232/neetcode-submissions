class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int trees = 0;
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) continue;

            trees += 1;

            dfs(i, -1, adjList, visited);
        }

        return trees;
    }

    private void dfs(int i, int parent, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        if (visited.contains(i)) return;

        visited.add(i);

        for (int neighbor : adjList.get(i)) {
            if (neighbor == parent) continue;

            dfs(neighbor, i, adjList, visited);
        }
    }
}
