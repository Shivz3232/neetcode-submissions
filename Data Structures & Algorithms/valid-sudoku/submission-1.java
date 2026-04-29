class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] row = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] column = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};

            for (int j = 0; j < 9; j++) {
                
                if (board[i][j] != '.') {
                    continue;
                }

                if (row[board[i][j] - 49] == 1) {
                    return false;
                } else {
                    row[board[i][j] - 49] = 1;
                }
            }
        }

        return true;
    }
}
