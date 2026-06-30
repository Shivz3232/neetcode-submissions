class Solution {
    public int reverseBits(int n) {
        int result = 0;

        Long x = Integer.toUnsignedLong(n);

        // System.out.println(n);

        // if (n < 0) {
        //     result = 1;
        //     n *= -1;
        // } else {
        //     result = 0;
        // }

        int j = 31;
        while (x != 0) {
            // System.out.println(n);

            if ((x & 1) != 0) result |= 1 << j;

            x >>= 1;
            j--;
        }

        return result;
    }
}
