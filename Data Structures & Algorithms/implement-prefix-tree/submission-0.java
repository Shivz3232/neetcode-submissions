class PrefixTree {
    private final Node head;

    public PrefixTree() {
         this.head = new Node('0');
    }

    public void insert(String word) {
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
        Node n = head;

        for (int i = 0; i < word.length(); i++) {
            if (n.containsKey(word.charAt(i))) {
                n = n.get(word.charAt(i));
            } else {
                return false;
            }
        }

        return n.end;
    }

    public boolean startsWith(String prefix) {
        Node n = head;

        for (int i = 0; i < prefix.length(); i++) {
            if (n.containsKey(prefix.charAt(i))) {
                n = n.get(prefix.charAt(i));
            } else {
                return false;
            }
        }

        return true;
    }

    private static class Node {
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
    }
}
