class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        int[][] board = new int[n][n];

        dfs(n, n, board, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int size, int remaining, int[][] board, List<String> subresult, List<List<String>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(subresult));
            return;
        }

        for (int i = 0; i < size; i++) {
            if (!canPlace(size, board, size - remaining, i)) {
                continue;
            }

            board[size - remaining][i] = 1;
            subresult.add(buildPlacementString(size, i));

            dfs(size, remaining - 1, board, subresult, result);

            board[size - remaining][i] = 0;
            subresult.remove(subresult.size() - 1);
        }
    }

    private boolean canPlace(int size, int[][] board, int row, int col) {
        for (int i = col; i >= 0; i--) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = col; i < size; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < size; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private String buildPlacementString(int size, int position) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if (i == position) sb.append('Q');
            else sb.append('.');
        }

        return sb.toString();
    }
}
