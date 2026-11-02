class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        boolean isNeg = false;

        double y;
        if (x < 0) {
            isNeg = true;
            y = -1 * x;
        } else {
            y = x;
        }

        double m;
        if (n < 0) {
            y = 1 / y;
            m = -1 * (double) n;
        } else {
            m = (double) n;
        }

        boolean oddPow = m % 2 != 0;

        if (y == 1) {
            if (isNeg && oddPow) return -1;
            else return 1;
        }

        double[] memo = new double[32];
        memo[0] = y;

        double result = memo[0];

        // Instead of going linearly build the result in powers of 2;
        // This leverages previously computed values, saving time.
        // y^1, y^2, y^4, y^8, ..., y^j
        int i = 1;
        double j = 2;
        while (j <= m) {
            result *= memo[i - 1];
            memo[i] = result;

            j *= 2;
            i += 1;
        }

        result = dfs(y, result, m - (j / 2), memo);

        if (isNeg && oddPow) return -1 * result;

        return result;
    }

    private double dfs(double y, double result, double m, double[] memo) {
        if (m == 0) return result * y;
        // if (m == 1) return result * y;

        int i = 1;
        int j = 2;
        while (j <= m) {
            result *= memo[i - 1];

            j *= 2;
            i += 1;
        }

        return dfs(y, result, m - (j / 2), memo);
    }

    private void displayMemo(double[] memo) {
        for (int i = 0; i < 31; i++) {
            System.out.printf("%.1f, ", memo[i]);
        }
        System.out.println();
    }
}
