class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix[0].length;
        int height = matrix.length;

        MatrixI startI = new MatrixI(0, 0);
        MatrixI endI = new MatrixI(height - 1, width - 1);
        MatrixI mid;

        int c = 0;
        while (c < 20 && startI.compareTo(endI) < 0) {
            c++;
            mid = findMiddle(startI, endI);
            int num = matrix[mid.row][mid.col];

            // System.out.print(startI + " | ");
            // System.out.print(mid + " | ");
            // System.out.println(endI);

            if (num < target) {
                if (mid.col + 1 < width) {
                    startI = new MatrixI(mid.row, mid.col + 1);
                } else if (mid.row + 1 < height) {
                    startI = new MatrixI(mid.row + 1, 0);
                }
            } else if (num == target) {
                return true;
            } else {
                endI = mid;
                if (mid.col - 1 >= 0) {
                    endI = new MatrixI(mid.row, mid.col - 1);
                } else {
                    endI = new MatrixI(mid.row - 1, width - 1);
                }
            }
        }

        // if (mid.compareTo(new MatrixI(height - 1, width - 1)) <= 0 && matrix[mid.row][mid.col] == target) {
        //     return true;
        // }

        return false;
    }

    private MatrixI findMiddle(MatrixI startI, MatrixI endI) {
        if (startI.compareTo(endI) < 0) {
            int colSum = startI.col + endI.col;
            int colMid;
            if (colSum % 2 == 0) {
                colMid = (int) colSum / 2;
            } else {
                colMid = (int) (colSum + 1) / 2;
            }
            if (startI.row == endI.row) {
                return new MatrixI(startI.row, colMid);
            } else { //start.row < end.row
                int rowSum = startI.row + endI.row;
                int rowMid;
                if (rowSum % 2 == 0) {
                    rowMid = (int) rowSum / 2;
                } else {
                    rowMid = (int) (rowSum + 1) / 2;
                }

                return new MatrixI(rowMid, colMid);
            }
        } else if (startI.compareTo(endI) == 0) {
            return new MatrixI(startI.row, startI.col);
        } else {
            throw new IllegalArgumentException();
        }
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
            if (row < o.row) {
                return -1;
            } else if (row == o.row) {
                if (col < o.col) {
                    return -1;
                } else if (col == o.col) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return row + ", " + col;
        }
    }
}
