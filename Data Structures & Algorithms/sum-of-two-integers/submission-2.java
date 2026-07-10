class Solution {
    public int getSum(int a, int b) {
        boolean isNegative = false;
        if (a < 0 && b < 0) {
            isNegative = true;
            a *= -1;
            b *= -1;
        }

        if (a == 0) return b;
        if (b == 0) return a;

        int mask = 1, c = 0, result = 0;

        int limit = 1 << 20;
        while (mask <= limit) {
            // System.out.println("Mask: " + mask + ", c: " + c + ", result: " + result);

            if (c == 1) {
                if (((mask & a) ^ (mask & b)) == 0) {
                    result |= mask;
                    
                    if (((mask & a) & (mask & b)) == 0) {
                        c = 0;
                    }
                }
            } else {
                if (((mask & a) ^ (mask & b)) != 0) {
                    result |= mask;
                } else {
                    if (((mask & a) & (mask & b)) != 0) {
                        c = 1;
                    }
                }
            }

            mask <<= 1;
        }

        if (isNegative) return -1 * result;

        return result;
    }
}
