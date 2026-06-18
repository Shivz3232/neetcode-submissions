class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Node> nodes = new HashMap<>();

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int l = prefixLength(w1, w2);

            if (l == w1.length() && l == w2.length()) continue;

            char u = w1.charAt(l);
            char v = w2.charAt(l);

            if (!adjList.containsKey(u)) {
                adjList.put(u, new Node(u));
            }

            adjList.get(u).children.add(v);
        }

        displayAdjList(adjList);

        int[] time = new int[1];
        int[] d = new int[26];
        int[] f = new int[26];
        for (char c : adjList.keySet()) {
            if (d[c - 97] == 0) {
                if (!dfs(c, adjList, time, d, f)) {
                    return "";
                }
            }
        }

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (f[i] != 0) {
                nodes.add(new Node((char) (i + 97), f[i]));
            }
        }

        Collections.sort(nodes);

        StringBuilder sb = new StringBuilder();

        for (Node n : nodes) {
            sb.append(n.c);
        }

        return sb.toString();
    }

    private boolean dfs(char c, Map<Character, Set<Character>> adjList, int[] time, int[] d, int[] f) {
        int cI = c - 97;

        if (d[cI] != 0) return false;

        d[cI] = ++time[0];

        if (adjList.containsKey(c)) {
            for (char child : adjList.get(c)) {
                if (!dfs(child, adjList, time, d, f))
                    return false;
            }
        }

        f[cI] = ++time[0];

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

    private void displayAdjList(Map<Character, Set<Character>> adjList) {
        for (char key : adjList.keySet()) {
            System.out.print(key + ": ");
            for (char c : adjList.get(key)) {
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
        public int s;
        public final Set<Character> children;

        Node(char c) {
            this.c = c;
            this.d = -1;
            this.f = -1;
            this.s = 0;
            this.children = new HashSet<>();
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.f, o.f) * -1;
        }
    }
}
