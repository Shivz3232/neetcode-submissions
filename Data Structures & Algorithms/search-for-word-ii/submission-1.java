class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;

        int[][] seen = new int[rows][cols];

        Node trie = new Node('0');
        for (String word : words) addWord(trie, word);
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, seen, i, j, trie, new StringBuilder(), result);

                if (result.size() == words.length) {
                    return result;
                }
            }
        }

        return result;
    }

    private void dfs(char[][] board, int[][] seen, int row, int col, Node prev, StringBuilder builder, List<String> result) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        if (seen[row][col] == 1) {
            return;
        }

        Node cur = prev.get(board[row][col]);

        if (cur == null) {
            return;
        }

        builder.append(board[row][col]);
        seen[row][col] = 1;

        if (cur.end && !cur.seen) {
            result.add(builder.toString());
            cur.seen = true;
        }

        dfs(board, seen, row - 1, col, cur, builder, result);
        dfs(board, seen, row, col - 1, cur, builder, result);
        dfs(board, seen, row + 1, col, cur, builder, result);
        dfs(board, seen, row, col + 1, cur, builder, result);

        seen[row][col] = 0;
        builder.deleteCharAt(builder.length() - 1);
    }

    private void addWord(Node head, String word) {
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

    private static class Node implements Iterable<Character> {
        public final char c;
        public boolean end;
        public boolean seen;
        private final Map<Character, Node> children;

        Node(char c) {
            this.c = c;
            this.end = false;
            this.seen = false;
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
