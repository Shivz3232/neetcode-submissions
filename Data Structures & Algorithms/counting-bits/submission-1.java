class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++)
            result[i] = countBits2(i);

        return result;
    }

    public int countBits2(int n) {
        int result = 0;

        while (n != 0 && ++result > 0)
            n = (n - 1) & n;

        return result;
    }
}
