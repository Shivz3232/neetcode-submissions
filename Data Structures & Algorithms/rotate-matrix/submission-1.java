class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // For all sub rings
        for (int i = 0; i < n / 2; i++) {
            // For each element in one wing of the sub-ring
            for (int j = i; j < m - i - 1; j++) {
                int tmp = matrix[i][j];

                int nextI = i;
                int nextJ = j;

                // Rotate the elements
                for (int k = 0; k < 4; k++) {
                    int tmpI = nextI;
                    int tmpJ = nextJ;

                    nextI = tmpJ;
                    nextJ = m - tmpI - 1;

                    // Swap tmp with nextPos
                    int swap = matrix[nextI][nextJ];
                    matrix[nextI][nextJ] = tmp;
                    tmp = swap;
                }
            }
        }
    }
}
