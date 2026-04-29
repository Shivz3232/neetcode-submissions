class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix[0].length;
        int height = matrix.length;

        int left = 0;
        int right = width * height - 1;
        int mid = findMid(left, right);
        MatrixI i = toMatrixI(mid, width);

        System.out.println(left + ", " + right);
        System.out.println(mid);
        System.out.println(i);
        System.out.println();

        while (left <= right) {
            int num = matrix[i.row][i.col];
            if (num < target) {
                left = mid + 1;
            } else if (num == target) {
                return true;
            } else {
                right = mid - 1;
            }

            mid = findMid(left, right);
            i = toMatrixI(mid, width);

            System.out.println(left + ", " + right);
            System.out.println(mid);
            System.out.println(i);
            System.out.println();
        }

        // if (left == right && left < (width * height - 1) && matrix[i.row][i.col] == target) {
        //     return true;
        // }

        return false;
    }

    private int findMid(int left, int right) {
        int sum = left + right;
        if (sum % 2 == 0) {
            return (int) sum / 2;
        } else {
            return (int) (sum + 1) / 2;
        }
    }

    private MatrixI toMatrixI(int i, int width) {
        int q = (int) i / width;
        int r = (i) - (width * q);

        return new MatrixI(q, r);
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
