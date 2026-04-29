class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix[0].length;
        int height = matrix.length;

        MatrixI startI = new MatrixI(0, 0);
        MatrixI endI = new MatrixI(height - 1, width - 1);
        MatrixI mid = findMiddle(startI, endI);

        while (startI.compareTo(endI) < 0) {
            if ()
        }

        if (mid.compareTo(new MatrixI(height - 1, width - 1)) <= 0 && matrix[mid.row][mid.col] == target) {
            return true;
        }

        return false;
    }

    private MatrixI findMiddle(MatrixI startI, MatrixI endI) {
        return null;
    }

    private class MatrixI implements Comparable<MatrixI> {
        public final int row;
        public final int col;

        public MatrixI(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(MatrixI o) {
        return 0;
        }
    }
}
