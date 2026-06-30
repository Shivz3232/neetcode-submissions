class Solution {
    public int[] countBits(int n) {
        // if (n == 0) return new int[]{};
        // if (n == 1) return new int[]{0, 1};
        // if (n == 2) return new int[]{0, 1, 1};

        int[] result = new int[n + 1];
        // result[0] = 0;
        // result[1] = 1;
        // result[2] = 1;

        for (int i = 0; i <= n; i++) {
            result[i] = countBits2(i);
        }

        return result;
    }

    public int countBits2(int n) {
        int result = 0;

        int x;
        while (n != 0) {
            x = n;
            n = n - 1;
            n &= x;

            result += 1;
        }

        return result;
    }
}
