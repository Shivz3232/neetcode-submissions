class Solution {
    public String longestPalindrome(String s) {
        // if (s.length() == 1) return s;

        int[][] memo = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            memo[i][i] = 1;
        }

        int n = s.length();

        for (int l = 1; l < n; l++) {
            for (int i = 0; i < n - l; i++) {
                int j = i + l;

                if (isPalindrome(s, i, j)) {
                    memo[i][j] = j - i + 1;
                } else {
                    memo[i][j] = Math.max(
                        memo[i][j - 1],
                        memo[i + 1][j]
                    );
                }
            }
        }


        int i = 0;
        int j = s.length() - 1;

        int optimal_value = memo[i][j];
        while (i >= 0 && j > i && (memo[i][j - 1] == optimal_value || memo[i + 1][j] == optimal_value)) {
            if (memo[i][j - 1] == optimal_value) {
                j--;
            } else {
                i++;
            }
        }

        return s.substring(i, j + 1);
    }

    private void displayMemo(int[][] memo, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(memo[i][j] + ", ");
            }
            System.out.println();
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
