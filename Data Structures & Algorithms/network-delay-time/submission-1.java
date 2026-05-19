class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Node>> adjList = new HashMap<>();
        
        for (int i = 0; i < n; i++)
            adjList.put(i + 1, new ArrayList<>());

        for (int[] time : times)
            adjList.get(time[0]).add(new Node(time[1], time[2]));

        Integer[] discoveryTimes = new Integer[n];
        for (int i = 0; i < n; i++)
            discoveryTimes[i] = Integer.MAX_VALUE;
        
        discoveryTimes[k - 1] = 0;

        displayAdjList(adjList, n);

        Set<Integer> visited = new HashSet<>();
        dfs(k, 0, adjList, discoveryTimes, visited);

        // for (int i = 0; i < n; i++)
        //     System.out.print(discoveryTimes[i] + ", ");
        // System.out.println();

        Arrays.sort(discoveryTimes, Collections.reverseOrder());

        if (discoveryTimes[0] == Integer.MAX_VALUE) return -1;
        else return discoveryTimes[0];
    }

    private void dfs(int i, int time, Map<Integer, List<Node>> adjList, Integer[] discoveryTimes, Set<Integer> visited) {
        if (visited.contains(i)) return;

        visited.add(i);

        for (Node n : adjList.get(i)) {
            if (time + n.t < discoveryTimes[n.i - 1]) {
                discoveryTimes[n.i - 1] = time + n.t;
            }

            dfs(n.i, time + n.t, adjList, discoveryTimes, visited);
        }
    }

    private class Node {
        public final int i;
        public final int t;

        public Node(int i, int t) {
            this.i = i;
            this.t = t;
        }
    }

    private void displayAdjList(Map<Integer, List<Node>> adjList, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ": ");
            for (Node node : adjList.get(i + 1)) {
                System.out.print("(" + node.i + "," + node.t + ") ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
