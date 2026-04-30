class Solution {
    public String longestPalindrome(String s) {
        return aux(s, 0, s.length() - 1);
    }

    private String aux(String s, int i, int j) {
        if (j < i) {
            return "";
        }
        
        if (isPalindrome(s, i, j)) {
            return s.substring(i, j + 1);
        } else {
            String a = aux(s, i + 1, j);
            String b = aux(s, i, j - 1);

            if (a.length() > b.length()) {
                return a;
            } else {
                return b;
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        int half = (j - i + 1) / 2;
        for (int k = 0; k < half; k++) {
            if (s.charAt(i + k) != s.charAt(j - k)) {
                return false;
            }
        }

        return true;
    }
}
