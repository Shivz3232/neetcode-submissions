class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        builder.append('(');

        generateParenthesis(n, n - 1, n, result, builder);
        
        return result;
    }

    private void generateParenthesis(int n, int opening, int closing, List<String> result, StringBuilder builder) {
        if (closing == 0) {
            // System.out.println(builder.toString());

            if (opening > 0) {
                throw new IllegalStateException("Ran out of closing braces!");
            }

            result.add(builder.toString());
            return;
        }

        if (opening > 0) {
            builder.append('(');
            generateParenthesis(n, opening - 1, closing, result, builder);
            builder.deleteCharAt(builder.length() - 1);
        }

        if (closing > opening) {
            builder.append(')');
            generateParenthesis(n, opening, closing - 1, result, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
