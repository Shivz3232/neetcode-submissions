class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> nodes = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            if (nodes.containsKey(prerequisite[0])) {
                nodes.get(prerequisite).addChild(prerequisite[1]);
            } else {
                Node n = new Node(prerequisite[0]);
                n.addChild(prerequisite[1]);

                nodes.put(prerequisite[0], n);
            }
        }

        // displayNodes(numCourses, nodes);

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {            
            if (!dfs(i, nodes, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int courseId, Map<Integer, Node> nodes, int[] visited) {
        if (visited[courseId] == 1) return false;
        if (visited[courseId] == 2) return true;

        // If no children
        if (!nodes.containsKey(courseId)) {
            visited[courseId] = 2;
            return true;
        }

        visited[courseId] = 1;

        for (int childId : nodes.get(courseId).children) {            
            if (!dfs(childId, nodes, visited)) {
                return false;
            }
        }

        visited[courseId] = 2;

        return true;
    }

    private class Node {
        public final int id;
        public final Set<Integer> children;

        public Node(int id) {
            this.id = id;
            this.children = new HashSet<>();
        }

        public void addChild(int id) {
            children.add(id);
        }
    }

    private void displayNodes(int numCourses, Map<Integer, Node> nodes) {
        for (int i = 0; i < numCourses; i++) {
            if (nodes.containsKey(i)) {
                Node n = nodes.get(i);

                System.out.print(n.id + " -> ");
                for (int child : n.children) {
                    System.out.print(child + ", ");
                }
            }
        }
    }
}
