class Solution {
    public int hammingWeight(int n) {
        int result = 0;

        int x = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & x) != 0) result += 1;

            x <<= 1;
        }

        return result;
    }
}
