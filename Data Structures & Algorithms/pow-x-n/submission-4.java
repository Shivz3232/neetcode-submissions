class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        if (n == 0) return 1;

        boolean pos;
        if (x > 0) pos = true;
        else if (x < 0) {
            if (n % 2 == 0) pos = true;
            else pos = false;
        } else pos = false;

        double y;
        if (n < 0) {
            n *= -1;
            y = 1 / x;
        } else {
            y = x;
        }

        double m = (double) n;

        double[] memo = new double[31];
        memo[0] = y;

        double result = memo[0];

        int i = 1;
        int j = 2;
        while (j < n) {
            result *= memo[i - 1];
            memo[i] = result;

            j *= 2;
            i += 1;
        }

        for (int k = 0; k < n - (j / 2); k++) {
            result *= y;
        }

        // displayMemo(memo);

        if (pos) return result;

        return -1 * result;
    }

    private void displayMemo(double[] memo) {
        for (int i = 0; i < 31; i++) {
            System.out.printf("%.1f, ", memo[i]);
        }
        System.out.println();
    }
}
