class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Node> nodes = new ArrayList<>();

        for (int id = 0; id < numCourses; id++) {
            nodes.add(new Node(id));
        }

        for (int[] prereq : prerequisites) {
            nodes.get(prereq[1]).children.add(prereq[0]);
        }

        int[] t = new int[1];
        for (Node n : nodes) {
            if (n.f == -1) {
                if (!dfs(n, nodes, t)) {
                    return new int[0];
                }
            }
        }

        nodes.sort((n1, n2) -> {
            return -1 * Integer.compare(n1.f, n2.f);
        });

        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = nodes.get(i).id;
        }

        return result;
    }

    private boolean dfs(Node n, List<Node> nodes, int[] t) {
        if (n.f != -1) return true;
        if (n.d != -1) return false;

        n.d = ++t[0];
        for (int child : n.children) {
            if (!dfs(nodes.get(child), nodes, t)) {
                return false;
            }
        }

        n.f = ++t[0];

        return true;
    }

    private class Node {
        final public int id;
        public int d;
        public int f;
        final public Set<Integer> children;

        Node(int id) {
            this.id = id;
            this.d = -1;
            this.f = -1;
            this.children = new HashSet<>();
        }
    }
}
