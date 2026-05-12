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

        for (int i = 0; i < roots.size(); i++) {
            if (dfs(roots.get(i), i + 1)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(Node n, int visitedI) {
        if (n.visited == visitedI) return false;

        n.visited += 1;

        for (Node child : n.children) {
            if (!dfs(child, visitedI)) {
                return false;
            }
        }

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
