class Solution {
    public double myPow(double x, int n) {
        if (x == 1) return x;

        if (x == -1) {
            if (Math.abs(n) % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }

        if (x == 0) {
            return 0;
        }

        double y;
        if (n < 0) {
            y = 1 / x;
        } else if (n == 0) {
            return 1;
        } else {
            y = x;
        }

        double m = (double)n;

        double result = 1;

        for (int i = 0; i < Math.abs(m); i++) {
            result *= y;
        }

        // System.out.printf("%d, %d\n", Integer.MAX_VALUE, Math.abs(n));

        return result;
    }
}
