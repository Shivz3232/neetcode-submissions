// ["O","X","X","O","X"],
// ["X","O","O","X","O"],
// ["X","O","X","O","X"],
// ["O","X","O","O","O"],
// ["X","X","O","X","O"]


// ["O","X","X","O","X"
// ["X","X","X","X","O"
// ["X","X","X","X","X"
// ["O","X","X","X","X"
// ["X","X","X","X","X"


class Solution {
    public void solve(char[][] board) {
        int[][] visited = new int[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && dfs(board, i, j, visited)) {
                    fix(board, i, j);
                    // System.out.println(i + ", " + j);
                }
            }
        }
    }

    private void fix(char[][] board, int i, int j) {
        if (!validIdx(board, i, j)) return;
        if (board[i][j] == 'X') return;
        
        board[i][j] = 'X';

        fix(board, i - 1, j);
        fix(board, i, j - 1);
        fix(board, i + 1, j);
        fix(board, i, j + 1);
    }

    private boolean dfs(char[][] board, int i, int j, int[][] visited) {
        if (!validIdx(board, i, j)) return false;
        if (board[i][j] == 'X') return true;
        if (visited[i][j] == 2) return false;
        if (visited[i][j] == 1) return true;

        visited[i][j] = 1;

        boolean proceed = false;

        proceed = dfs(board, i - 1, j, visited);
        if (!proceed) {
            visited[i][j] = 2;
            return false;
        };

        proceed = dfs(board, i, j - 1, visited);
        if (!proceed) {
            visited[i][j] = 2;
            return false;
        };

        proceed = dfs(board, i, j + 1, visited);
        if (!proceed) {
            visited[i][j] = 2;
            return false;
        };

        proceed = dfs(board, i + 1, j, visited);
        if (!proceed) {
            visited[i][j] = 2;
            return false;
        };
        
        return true;
    }

    private boolean validIdx(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
