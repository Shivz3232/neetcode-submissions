class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (c == ')' && stack.peek() == '(') {
                } else if (c == ']' && stack.peek() == '[') {
                } else if (c == '}' && stack.peek() == '{') {
                } else {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
