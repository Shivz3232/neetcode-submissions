class Solution {
    public int reverseBits(int n) {
        int result = 0;

        int j = 31;
        while (n != 0) {

            if ((n & 1) != 0) result |= 1 << j;

            n >>= 1;
            j--;
            
        }

        return result;
    }
}
