class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        int[] memo = new int[s.length()];
        memo[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) == '0') {
                return 0;
            } else if (s.charAt(i) == '0' || s.charAt(i - 1) == '0') {
                if (s.charAt(i) == '0') {
                    if ((int) s.charAt(i - 1) <= 50) {
                        memo[i] = memo[i - 1] - 1;
                    } else {
                        return 0;
                    }
                } else {
                    memo[i] = memo[i - 1];
                }
            } else {
                if (s.charAt(i - 1) <= 50 && s.charAt(i) <= 54) {
                    memo[i] = memo[i - 1] + 1;
                } else {
                    memo[i] = memo[i - 1];
                }
            }
        }

        return memo[s.length() - 1];
    }
}
