class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adjList = new HashMap<>();
        adjList.put(beginWord, new ArrayList<>());
        adjList.put(endWord, new ArrayList<>());

        boolean endWordPresent = false;
        for (String word : wordList) {
            if (word.equals(endWord))
                endWordPresent = true;

            adjList.put(word, new ArrayList<>());
        }

        if (!endWordPresent) {
            return 0;
        }

        for (String word : wordList)
            if (reachable(beginWord, word)) {
                adjList.get(beginWord).add(word);
                adjList.get(word).add(beginWord);
            }
        
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String s1 = wordList.get(i);
                String s2 = wordList.get(j);

                if (reachable(s1, s2)) {
                    adjList.get(s1).add(s2);
                    adjList.get(s2).add(s1);
                }
            }
        }

        // displayAdjList(adjList);

        return bfs(beginWord, endWord, adjList);
    }

    private int bfs(String source, String dest, Map<String, List<String>> adjList) {
        Queue<Node> q = new LinkedList<>();

        Set<String> visited = new HashSet<>();

        q.add(new Node(source, 1));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            visited.add(cur.s);

            if (cur.s.equals(dest)) return cur.d;

            for (String neighbor : adjList.get(cur.s)) {
                if (visited.contains(neighbor)) continue;

                q.add(new Node(neighbor, cur.d + 1));
            }
        }

        return 0;
    }

    private class Node {
        public final String s;
        public final int d;

        public Node(String s, int d) {
            this.s = s;
            this.d = d;
        }
    }

    private boolean reachable(String s1, String s2) {
        int n = s1.length();

        boolean diffSeen = false;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            else if (diffSeen) return false;
            else diffSeen = true;
        }

        return true;
    }

    private void displayAdjList(Map<String, List<String>> adjList) {
        for (String key : adjList.keySet()) {
            System.out.print(key + ": ");
            for (String neighbor : adjList.get(key)) {
                System.out.print(neighbor + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
