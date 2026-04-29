class Solution {
    public boolean exist(char[][] board, String word) {
        boolean found = false;

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; !found && i < rows; i++) {
            for (int j = 0; !found && j < cols; j++) {
                found = exist(board, word, i, j, 0);
            }
        }

        return found;
    }

    public boolean exist(char[][] board, String word, int i, int j, int k) {
        if (k >= word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        if (board[i][j] != word.charAt(k)) {
            return false;
        }

        char c = board[i][j];

        board[i][j] = '0';

        boolean found = exist(board, word, i + 1, j, k + 1)
            || exist(board, word, i, j + 1, k + 1)
            || exist(board, word, i - 1, j, k + 1)
            || exist(board, word, i, j - 1, k + 1);
        
        board[i][j] = c;

        return found;
    }
}
