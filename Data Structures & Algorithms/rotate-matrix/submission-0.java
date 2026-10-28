class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] prevPos = new int[2];
        int[] nextPos = new int[2];
        // For all sub rings
        for (int i = 0; i < n / 2; i++) {
            // For each element in one wing of the sub-ring
            for (int j = i; j < m - i - 1; j++) {
                int tmp = matrix[i][j];

                nextPos[0] = i;
                nextPos[1] = j;

                // Rotate the elements
                for (int k = 0; k < 4; k++) {
                    getNextPos(nextPos[0], nextPos[1], n, m, nextPos);

                    // Swap tmp with nextPos
                    int swap = matrix[nextPos[0]][nextPos[1]];
                    matrix[nextPos[0]][nextPos[1]] = tmp;
                    tmp = swap;
                }
            }
        }
    }

    private void getNextPos(int i, int j, int n, int m, int[] result) {
        result[0] = j;
        result[1] = m - i - 1;
    }
}
