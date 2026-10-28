class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int swap, tmp, prevI, prevJ, nextI, nextJ;
        // For all sub rings
        for (int i = 0; i < n / 2; i++) {
            // For each element in one wing of the sub-ring
            for (int j = i; j < m - i - 1; j++) {
                tmp = matrix[i][j];

                prevI = i;
                prevJ = j;
                nextI = prevJ;
                nextJ = m - prevI - 1;
                swap = matrix[nextI][nextJ];
                matrix[nextI][nextJ] = tmp;
                tmp = swap;

                prevI = nextI;
                prevJ = nextJ;
                nextI = prevJ;
                nextJ = m - prevI - 1;
                swap = matrix[nextI][nextJ];
                matrix[nextI][nextJ] = tmp;
                tmp = swap;

                prevI = nextI;
                prevJ = nextJ;
                nextI = prevJ;
                nextJ = m - prevI - 1;
                swap = matrix[nextI][nextJ];
                matrix[nextI][nextJ] = tmp;
                tmp = swap;

                prevI = nextI;
                prevJ = nextJ;
                nextI = prevJ;
                nextJ = m - prevI - 1;
                swap = matrix[nextI][nextJ];
                matrix[nextI][nextJ] = tmp;
                tmp = swap;
            }
        }
    }
}
