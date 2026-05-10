class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O') {
                    if (isValid(board, i, j)) {
                        fix(board, i, j);
                    }
                }
                
            }
        }
    }

    private void fix(char[][] board, int i, int j) {
        board[i][j] = 'X';
        board[i][j + 1] = 'X';
        board[i + 1][j] = 'X';
        board[i + 1][j + 1] = 'X';
    }

    private boolean isValid(char[][] board, int i, int j) {
        if (i - 1 >= 0 && j + 1 < board.length) {
            if (board[i - 1][j] == 'O' || board[i - 1][j + 1] == 'O') {
                return false;
            }
        }

        if (i + 1 < board.length && j - 1 >= 0) {
            if (board[i][j - 1] == 'O' || board[i + 1][j - 1] == 'O') {
                return false;
            }
        }

        if (i + 1 < board.length && j + 2 < board.length) {
            if (board[i][j + 2] == 'O' || board[i + 1][j + 2] == 'O') {
                return false;
            }
        }

        if (i + 2 < board.length && j + 1 < board.length) {
            if (board[i + 2][j] == 'O' || board[i + 2][j + 1] == 'O') {
                return false;
            }
        }

        return true;
    }
}
