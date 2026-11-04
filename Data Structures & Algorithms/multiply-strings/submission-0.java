class Solution {
    public String multiply(String num1, String num2) {
        String a, b;
        if (num1.length() < num2.length()) {
            a = num2;
            b = num1;
        } else {
            a = num1;
            b = num2;
        }

        int n = a.length();
        int m = b.length();

        int[] result = new int[n + m];

        for (int i = 0; i < m; i++) {
            int carry = 0;

            for (int j = 0; j < n; j++) {
                int p = c2i(a.charAt(n - j - 1)) * c2i(b.charAt(m - i - 1)) + carry;

                carry = p / 10;
                
                result[n + m - (i + j) - 1] += p % 10;
            }

            result[m - i - 1] += carry; // n + m - (i + j) where j = n
        }

        // Flatten result by propagating carries
        int carry = 0;
        for (int i = n + m - 1; i >= 0; i--) {
            int x = result[i] + carry;

            carry = x / 10;

            result[i] = x % 10;
        }

        StringBuilder sb = new StringBuilder();

        boolean zeroes = true;
        for (int i = 0; i < n + m; i++) {
            if (zeroes) {
                if (result[i] == 0) continue;
                else {
                    zeroes = false;
                }
            }

            sb.append(result[i]);
        }

        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }

    private int c2i(char c) {
        return c - '0';
    }

    private void disp(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf("%d, ", arr[i]);
        }
        System.out.println();
    }
}
