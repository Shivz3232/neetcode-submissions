class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j != 0 && ++result[i] > 0)
                j = (j - 1) & j;

            // for (int j = i; j != 0 && ++result[i] > 0; j = (j - 1) & j);
        }

        return result;
    }
}
