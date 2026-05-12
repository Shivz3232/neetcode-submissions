class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 0; i < edges.length; i++) {
            Node child = nodes.get(edges[i][1]);
            child.parents += 1;
            
            nodes.get(edges[i][0]).children.add(child);
        }

        List<Node> roots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nodes.get(i).parents == 0) {
                roots.add(nodes.get(i));
            }
        }

        if (roots.size() != 1) return false;

        int[] time = new int[1];
        if (!dfs(roots.get(0), time)) {
            return false;
        }

        return true;
    }

    private boolean dfs(Node n, int[] time) {
        if (n.visited == 1) return false;

        n.d = ++time[0];
        n.visited = 1;

        for (Node child : n.children) {
            if (!dfs(child, time)) {
                return false;
            }
        }

        n.f = ++time[0];

        return true;
    }

    private class Node {
        public final int id;
        public final List<Node> children;
        public int parents;
        public int d;
        public int f;
        public int visited;

        Node(int id) {
            this.id = id;
            this.children = new ArrayList<>();
            this.parents = 0;
            this.d = -1;
            this.f = -1;
            this.visited = 0;
        }
    }
}
