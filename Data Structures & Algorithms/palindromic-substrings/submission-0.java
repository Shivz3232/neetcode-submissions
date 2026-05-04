class Solution {
    public int countSubstrings(String s) {
        int result = 0;

        // int res = 0, resLen = 1;
        for (int i = 0; i < s.length(); i++) {
            result++;

            // Odd
            {
                int k = 1;
                while (i - k >= 0 && i + k < s.length() && s.charAt(i - k) == s.charAt(i + k)) {
                    result++;
                    k++;
                }

                // k--;

                // if (k * 2 + 1 > resLen) {
                //     res = i - k;
                //     resLen = k * 2 + 1;
                // }
            }

            // Even - @TODO
            {
                int k = 0;
                while (i - k >= 0 && i + k + 1 < s.length() && s.charAt(i - k) == s.charAt(i + k + 1)) {
                    result++;
                    k++;
                }

                // if (k * 2 > resLen) {
                //     res = i - k + 1;
                //     resLen = k * 2;
                // }
            }
        }

        return result;
    }
}
