class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();

        while (i < j) {
            if (!(Character.isDigit(s.charAt(i)) || Character.isAlphabetic(s.charAt(i)))) {
                i++;
            } else if (!(Character.isDigit(s.charAt(j)) || Character.isAlphabetic(s.charAt(j)))) {
                j--;
            } else if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
