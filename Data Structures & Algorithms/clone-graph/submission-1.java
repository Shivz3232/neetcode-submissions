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
        Set<Integer> s = new HashSet<>();

        return dfs(node, s, null);
    }

    private Node dfs(Node node, Set<Integer> s, Node parent) {
        if (node == null) {
            return null;
        }

        if (s.contains(node.val)) {
            return null;
        }

        Node clone = new Node(node.val);
        s.add(node.val);

        if (parent != null) {
            clone.neighbors.add(parent);
        }

        for (Node neighbour : node.neighbors) {
            Node t = dfs(neighbour, s, clone);

            if (t == null) continue;

            clone.neighbors.add(t);
        }

        return clone;
    }
}