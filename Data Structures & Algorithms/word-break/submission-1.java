// What is the minimum/maximum number of cuts required to split
// into valid words?

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length()];

        return aux(s, wordDict, 0, memo);
    }

    private boolean aux(String s, List<String> wordDict, int i, int[] memo) {
        if (i >= s.length()) return true;
        if (memo[i] == 1) return true;
        if (memo[i] == -1) return false;
        
        for (int k = i; k < s.length(); k++) {
            int subStrLen = k - i + 1;
            
            if (findWord(s, i, subStrLen, wordDict) != -1) {
                boolean match = aux(s, wordDict, k + 1, memo);
                if (match) {
                    memo[i] = 1;
                    return match;
                }
            } else {
                // System.out.print("Not found: ");
                // displaySubStr(s, i, subStrLen);
            }
        }

        memo[i] = -1;
        return false;
    }

    private int findWord(String s, int i, int subStrLen, List<String> wordDict) {
        for (int p = 0; p < wordDict.size(); p++) {
            String word = wordDict.get(p);
            
            if (word.length() != subStrLen) continue;

            boolean match = true;
            for (int k = 0; k < subStrLen; k++) {
                if (s.charAt(i + k) != word.charAt(k)) {
                    match = false;
                    break;
                }
            }

            if (match) return p;
        }

        return -1;
    }

    private void displaySubStr(String s, int i, int len) {
        for (int k = i; k < len; k++) {
            System.out.print(s.charAt(k));
        }
        System.out.println();
    }
}
