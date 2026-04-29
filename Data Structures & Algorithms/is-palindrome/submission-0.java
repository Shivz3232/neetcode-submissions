class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();

        while (i < j) {
            while (!(Character.isDigit(s.charAt(i)) || Character.isAlphabetic(s.charAt(i))) && i < j) {
                i++;
            }

            if (!(Character.isDigit(s.charAt(i)) || Character.isAlphabetic(s.charAt(i)))) {
                return false;
            }

            while (!(Character.isDigit(s.charAt(j)) || Character.isAlphabetic(s.charAt(j))) && i < j) {
                j--;
            }

            if (!(Character.isDigit(s.charAt(j)) || Character.isAlphabetic(s.charAt(j)))) {
                return false;
            }

            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
