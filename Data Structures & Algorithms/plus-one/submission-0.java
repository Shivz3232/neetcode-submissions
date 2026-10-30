class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        int[] result = new int[n + 1];

        int carry = 1;
        for (int i = n; i > 0; i--) {
            if (carry == 0) {
                result[i] = digits[i - 1];
            } else {
                int sum = digits[i - 1] + carry;

                if (sum >= 10) {
                    result[i] = sum % 10;
                } else {
                    result[i] = sum;
                    carry = 0;
                }
            }
        }

        if (carry == 1) {
            result[0] = 1;
            return result;
        }

        return Arrays.copyOfRange(result, 1, n + 1);
    }
}
