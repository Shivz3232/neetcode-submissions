class Solution {
    public int reverseBits(int n) {
        int result = 0;

        Long x = Integer.toUnsignedLong(n);

        int j = 31;
        while (x != 0) {
            if ((x & 1) != 0) result |= 1 << j;

            x >>= 1;
            j--;
        }

        return result;
    }
}
