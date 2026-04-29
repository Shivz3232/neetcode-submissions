class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        List<String> subresult = new ArrayList<>();

        dfs(s, 0, subresult, result);

        return result;
    }

    private void dfs(String s, int i, List<String> subresult, List<List<String>> result) {
        if (i >= s.length()) {
            result.add(new ArrayList<>(subresult));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                subresult.add(s.substring(i, j + 1));
                dfs(s, j + 1, subresult, result);
                subresult.remove(subresult.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
