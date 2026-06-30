class Solution {
    public int[] countBits(int n) {
        if (n == 0) return new int[]{0};
        if (n == 1) return new int[]{0, 1};

        int[] result = new int[n + 1];
        result[0] = 0;

        if (n == 0) return result;

        result[1] = 1;

        if (n == 1) return result;

        long nextExpV = 2;
        int j = 1;
        for (int i = 2; i <= n; i++) {

            if (i == nextExpV) {
                result[i] = 1;
                nextExpV *= 2;
                j = 1;
            } else {
                result[i] = 1 + result[j];
                j += 1;
            }

        }

        return result;
    }
}
