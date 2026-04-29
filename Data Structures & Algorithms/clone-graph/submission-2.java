/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> m = new HashMap<>();

        return dfs(node, m, null);
    }

    private Node dfs(Node node, Map<Integer, Node> m, Node parent) {
        if (node == null) {
            return null;
        }

        if (m.containsKey(node.val)) {
            return m.get(node.val);
        }

        Node clone = new Node(node.val);
        m.put(node.val, clone);

        if (parent != null) {
            clone.neighbors.add(parent);
        }

        for (Node neighbour : node.neighbors) {
            if (parent != null && neighbour.val == parent.val) continue;

            Node t = dfs(neighbour, m, clone);

            if (t == null) continue;

            clone.neighbors.add(t);
        }

        return clone;
    }
}