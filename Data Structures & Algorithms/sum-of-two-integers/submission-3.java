class Solution {
    public int getSum(int a, int b) {
        Case cse;
        
        if (a > 0 && b > 0) {
            cse = Case.BOTH_POSITIVE;
        } else if (a < 0 && b < 0) {
            cse = Case.BOTH_NEGATIVE;
        } else if ((a < 0 && Math.abs(a) > b) || (b < 0 && Math.abs(b) > a)) {
            cse = Case.LARGER_NEGATIVE;
        } else {
            cse = Case.LARGER_POSITIVE;
        }

        if (!(cse == Case.BOTH_POSITIVE || cse == Case.LARGER_POSITIVE)) {
            a *= -1;
            b *= -1;
        }

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

        if (!(cse == Case.BOTH_POSITIVE || cse == Case.LARGER_POSITIVE)) {
            return result * -1;
        }

        return result;
    }

    private enum Case {
        BOTH_POSITIVE,
        BOTH_NEGATIVE,
        LARGER_NEGATIVE,
        LARGER_POSITIVE
    }
}
