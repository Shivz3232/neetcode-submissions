class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> keys = new HashMap<>();

        populateKeys(keys);

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        dfs(digits, 0, new StringBuilder(), result, keys);

        return result;
    }

    private void dfs(String digits, int i, StringBuilder builder, List<String> result, Map<Character, List<Character>> keys) {
        if (i >= digits.length()) {
            result.add(builder.toString());
            return;
        }

        List<Character> chars = keys.get(digits.charAt(i));
        for (int j = 0; j < chars.size(); j++) {
            builder.append(chars.get(j));
            dfs(digits, i + 1, builder, result, keys);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private void populateKeys(Map<Character, List<Character>> keys) {
        keys.put('2', List.of('a', 'b', 'c'));
        keys.put('3', List.of('d', 'e', 'f'));
        keys.put('4', List.of('g', 'h', 'i'));
        keys.put('5', List.of('j', 'k', 'l'));
        keys.put('6', List.of('m', 'n', 'o'));
        keys.put('7', List.of('p', 'q', 'r', 's'));
        keys.put('8', List.of('t', 'u', 'v'));
        keys.put('9', List.of('w', 'x', 'y', 'z'));
    }
}
