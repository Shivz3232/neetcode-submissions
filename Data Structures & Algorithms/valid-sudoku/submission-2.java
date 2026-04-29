class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] row = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] column = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};

            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (column[board[j][i] - 49] == 1) {
                        return false;
                    } else {
                        column[board[j][i] - 49] = 1;
                    }
                }

                if (board[i][j] != '.') {
                    if (row[board[i][j] - 49] == 1) {
                        return false;
                    } else {
                        row[board[i][j] - 49] = 1;
                    }
                }
            }
        }

        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                int[] bitset = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
            
                for (int i = x; i < x + 3; i++) {
                    for (int j = y; j < y + 3; j++) {
                        if (board[i][j] != '.') {
                            if (bitset[board[i][j] - 49] == 1) {
                                return false;
                            } else {
                                bitset[board[i][j] - 49] = 1;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
