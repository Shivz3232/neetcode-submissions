class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        int[] memo = new int[s.length()];
        for (int i = 0; i < s.length(); i++) memo[i] = -1;

        return aux(s, 0, memo);
    }

    private int aux(String s, int i, int[] memo) {
        if (i >= s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int x;
        if (i + 1 < s.length() && s.charAt(i) <= 50 && s.charAt(i + 1) <= 54) {
            x = aux(s, i + 1, memo) + aux(s, i + 2, memo);
            memo[i] = x; 
            return x;
        } else {
            x = aux(s, i + 1, memo);
            return x;
        }
    }
}
