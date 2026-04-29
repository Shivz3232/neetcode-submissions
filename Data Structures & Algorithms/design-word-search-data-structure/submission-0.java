class WordDictionary {
    private final Node head;

    public WordDictionary() {
        this.head = new Node('0');
    }

    public void addWord(String word) {
        Node n = head;

        for (int i = 0; i < word.length(); i++) {
            if (n.containsKey(word.charAt(i))) {
                n = n.get(word.charAt(i));
            } else {
                n = n.insert(word.charAt(i));
            }
        }

        n.end = true;
    }

    public boolean search(String word) {
        return dfsSearch(word, 0, head);
    }

    public boolean dfsSearch(String word, int i, Node n) {
        if (i >= word.length()) {
            return true;
        }

        if (n == null) {
            return false;
        }

        char c = word.charAt(i);

        if (c == '.') {
            for (Character child : n) {
                boolean found = dfsSearch(word, i + 1, n.get(child));

                if (found) return true;
            }

            return false;
        }

        return dfsSearch(word, i + 1, n.get(c));
    }

    private static class Node implements Iterable<Character> {
        private final char c;
        public boolean end;
        private final Map<Character, Node> children;

        Node(char c) {
            this.c = c;
            this.end = false;
            this.children = new HashMap<>();
        }

        public Node insert(char c) {
            if (children.containsKey(c)) {
                Node n = children.get(c);

                return n;
            } else {
                Node n = new Node(c);

                children.put(c, n);

                return n;
            }
        }

        public boolean containsKey(char c) {
            return children.containsKey(c);
        }

        public Node get(char c) {
            return children.get(c);
        }

        @Override
        public Iterator<Character> iterator() {
            return children.keySet().iterator();
        }
    }
}
