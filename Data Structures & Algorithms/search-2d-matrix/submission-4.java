class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix[0].length;
        int height = matrix.length;

        int left = 0;
        int right = width * height - 1;

        MatrixI mid;
        int c = 0;
        while (c < 10 && left < right) {
            c++;
            mid = findMiddle(left, right, width);

            // System.out.println(left + ", " + right);
            // System.out.println(mid);
            // System.out.println();

            int num = matrix[mid.row][mid.col];
            if (num < target) {
                left = mid.row * width + mid.col + 1;
            } else if (num == target) {
                return true;
            } else {
                right = mid.row * width + mid.col + 1;
            }
        }

        if (left == right && left <= width * height - 1) {
            mid = findMiddle(left, right, width);

            if (matrix[mid.row][mid.col] == target) {
                return true;
            }
        }

        return false;
    }

    private MatrixI findMiddle(int left, int right, int width) {
        int sum = left + right;

        int mid;
        if (sum % 2 == 0) {
            mid = (int) sum / 2;
        } else {
            mid = (int) (sum + 1) / 2;
        }

        int q = (int) mid / width;
        int r = (mid) - (width * q);

        if (q != 0 && r == 0) {
            q--;
            r = width - 1;
        } else if (r > 0) {
            r--;
        }

        return new MatrixI(q, r);
    }

    private int findColMid(MatrixI startI, MatrixI endI) {
        return 0;
    }

    private class MatrixI implements Comparable<MatrixI> {
        public final int row;
        public final int col;

        public MatrixI(int row, int col) {
            if (row < 0 || col < 0) {
                throw new IllegalArgumentException();
            }

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
