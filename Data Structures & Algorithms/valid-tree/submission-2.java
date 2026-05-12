class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 0; i < edges.length; i++) {
            Node child = nodes.get(edges[i][1]);

            nodes.get(edges[i][0]).children.add(child);
        }

        int nTrees = 0;
        for (int i = 0; i < n; i++) {
            Node node = nodes.get(i);

            if (node.color != Node.state.WHITE) continue;

            if (!dfs(node)) {
                return false;
            }

            nTrees += 1;
        }

        if (nTrees > 1) {
            return false;
        }

        return true;
    }

    private boolean dfs(Node n) {
        if (n.color != Node.state.WHITE) return false;

        n.color = Node.state.GRAY;

        for (Node child : n.children) {
            if (!dfs(child)) {
                return false;
            }
        }

        n.color = Node.state.BLACK;

        return true;
    }

    private class Node {
        public final int id;
        public final List<Node> children;
        public state color;

        Node(int id) {
            this.id = id;
            this.children = new ArrayList<>();
            this.color = state.WHITE;
        }

        public enum state {
            WHITE,
            GRAY,
            BLACK
        }
    }
}
