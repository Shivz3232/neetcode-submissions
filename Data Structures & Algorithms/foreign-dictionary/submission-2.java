class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Node> nodes = new HashMap<>();

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int l = prefixLength(w1, w2);

            if (l == w1.length() || l == w2.length()) continue;

            char u = w1.charAt(l);
            char v = w2.charAt(l);

            if (!nodes.containsKey(u)) {
                nodes.put(u, new Node(u));
            }

            nodes.get(u).children.add(v);

            if (!nodes.containsKey(v)) {
                nodes.put(v, new Node(v));
            }

            nodes.get(v).inDegree += 1;
        }

        // Collect all possible starter nodes
        List<Character> init = new ArrayList<>();
        for (char c : nodes.keySet())
            if (nodes.get(c).inDegree == 0)
                init.add(c);

        if (init.size() == 0) return "";

        int[] time = new int[1];
        for (char c : init) {
            if (!dfs(c, nodes, time)) {
                return "";
            }
        }

        displayNodes(nodes);
        List<Node> nodesL = new ArrayList<>();
        for (char key : nodes.keySet()) {
            nodesL.add(nodes.get(key));
        }

        Collections.sort(nodesL);

        StringBuilder sb = new StringBuilder();
        for (Node n : nodesL) {
            sb.append(n.c);
        }

        return sb.toString();
    }

    private boolean dfs(char c, Map<Character, Node> nodes, int[] time) {
        Node n = nodes.get(c);

        if (n.d != -1) return false;

        n.d = ++time[0];

        for (char child : nodes.get(c).children) {
            if (!dfs(child, nodes, time))
                return false;
        }

        n.f = ++time[0];

        return true;
    }

    private int prefixLength(String a, String b) {
        int l = a.length() < b.length() ? a.length() : b.length();

        int result = 0;
        for (int i = 0; i < l; i++) {
            if (a.charAt(i) != b.charAt(i)) break;
            result += 1;
        }

        return result;
    }

    private void displayNodes(Map<Character, Node> nodes) {
        for (char key : nodes.keySet()) {
            Node n = nodes.get(key);
            System.out.print(key + "(" + n.d + "," + n.f + ") : ");
            for (char c : n.children) {
                System.out.print(c + ", ");
            }
            System.out.println();
        }
    }

    private class Node implements Comparable<Node> {
        public final char c;
        public int inDegree;
        public int d;
        public int f;
        public final Set<Character> children;

        Node(char c) {
            this.c = c;
            this.inDegree = 0;
            this.d = -1;
            this.f = -1;
            this.children = new HashSet<>();
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.f, o.f) * -1;
        }
    }
}
