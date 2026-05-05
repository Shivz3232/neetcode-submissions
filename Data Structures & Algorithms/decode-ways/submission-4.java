class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        // if (1 <= s.length() && s.charAt(0) <= 50 && s.charAt(1) <= 54) {
        //     return aux(s, 1) + aux(s, 2);
        // } else {
        //     return aux(s, 1);
        // }

        return aux(s, 0);
    }

    private int aux(String s, int i) {
        if (i >= s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (i + 1 < s.length() && s.charAt(i) <= 50 && s.charAt(i + 1) <= 54) {
            return aux(s, i + 1) + aux(s, i + 2);
        } else {
            return aux(s, i + 1);
        }
    }
}
