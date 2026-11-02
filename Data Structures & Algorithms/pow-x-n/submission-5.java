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
            m = -1 * n;
        } else {
            m = (double) n;
        }

        boolean oddPow = m % 2 != 0;

        if (y == 1) {
            if (isNeg && oddPow) return -1;
            else return 1;
        }

        double[] memo = new double[31];
        memo[0] = y;

        double result = memo[0];

        int i = 1;
        int j = 2;
        while (j < m) {
            result *= memo[i - 1];
            memo[i] = result;

            j *= 2;
            i += 1;
        }

        for (int k = 0; k < m - (j / 2); k++) {
            result *= y;
        }

        // displayMemo(memo);

        if (isNeg && oddPow) return -1 * result;

        return result;
    }

    private void displayMemo(double[] memo) {
        for (int i = 0; i < 31; i++) {
            System.out.printf("%.1f, ", memo[i]);
        }
        System.out.println();
    }
}
