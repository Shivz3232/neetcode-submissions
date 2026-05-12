class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 0; i < edges.length; i++) {
            nodes.get(edges[i][0]).negibours.add(
                nodes.get(edges[i][1])
            );
            
            nodes.get(edges[i][1]).negibours.add(
                nodes.get(edges[i][0])
            );
        }

        int nTrees = 0;
        for (int i = 0; i < n; i++) {
            Node node = nodes.get(i);

            if (node.color != Node.state.WHITE) continue;

            if (nTrees == 1) return false;

            if (!dfs(node, -1)) {
                return false;
            }

            nTrees += 1;
        }

        return true;
    }

    private boolean dfs(Node n, int parent) {
        if (n.color != Node.state.WHITE) return false;

        n.color = Node.state.GRAY;

        for (Node child : n.negibours) {
            if (child.id == parent) continue;

            if (!dfs(child, n.id)) {
                return false;
            }
        }

        n.color = Node.state.BLACK;

        return true;
    }

    private class Node {
        public final int id;
        public final List<Node> negibours;
        public state color;

        Node(int id) {
            this.id = id;
            this.negibours = new ArrayList<>();
            this.color = state.WHITE;
        }

        public enum state {
            WHITE,
            GRAY,
            BLACK
        }
    }
}
