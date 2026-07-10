class Solution {
    public int getSum(int a, int b) {
        int result = 0;

        int l = 0;
        int c = 0;
        while (a > 0 || b > 0) {
            int i = a & 1;
            int j = b & 1;

            if (i == 1 && j == 1) {
                if (c == 1) {
                    result |= 1 << l;
                } else {
                    c = 1;
                }
            } else if (i == 1) {
                if (c == 1) {
                    // No op
                } else {
                    result |= 1 << l;
                }
            } else if (j == 1) {
                if (c == 1) {
                    // No op
                } else {
                    result |= 1 << l;
                }
            } else {
                if (c == 1) {
                    result |= 1 << l;
                    c = 0;
                }
            }

            a >>= 1;
            b >>= 1;

            l += 1;
        }

        if (c == 1) {
            result |= 1 << l;
            c = 0;
        }

        return result;
    }
}
