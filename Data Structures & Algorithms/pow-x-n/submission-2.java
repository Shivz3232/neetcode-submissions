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

        double result = 1;

        // System.out.printf("%.10f, %.10f\n", result, y);

        for (int i = 0; i < Math.abs(n); i++) {
            result *= y;
            // System.out.printf("%.10f, %.10f\n", result, y);
        }

        return result;
    }
}
