class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        int[] memo = new int[s.length()];
        for (int i = 0; i < s.length(); i++) memo[i] = -1;

        aux(s, 0, memo);

        for (int i = 0; i < s.length(); i++) {
            System.out.print(memo[i] + ", ");
        }
        System.out.println();

        return memo[0];
    }

    private int aux(String s, int i, int[] memo) {
        if (i >= s.length()) {
            return 1;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        if (s.charAt(i) == '0') {
            memo[i] = 0;
            return 0;
        }

        int x;
        if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= 54))) {
            x = aux(s, i + 1, memo) + aux(s, i + 2, memo);
            memo[i] = x;
            return x;
        } else {
            x = aux(s, i + 1, memo);
            memo[i] = x;
            return x;
        }
    }
}
