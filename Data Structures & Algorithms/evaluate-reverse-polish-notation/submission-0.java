class Solution {
    public int evalRPN(String[] tokens) {
        return evaluate(tokens, tokens.length - 1);
    }

    private int evaluate(String[] tokens, int opI) {
        int firstOperand;
        if (tokens[opI - 2].length() == 1 && isOperator(tokens[opI - 2].charAt(0))) {
            firstOperand = evaluate(tokens, opI - 2);
        } else {
            firstOperand = Integer.parseInt(tokens[opI - 2]);
        }

        int secondOperand;
        if (tokens[opI - 1].length() == 1 && isOperator(tokens[opI - 1].charAt(0))) {
            secondOperand = evaluate(tokens, opI - 1);
        } else {
            secondOperand = Integer.parseInt(tokens[opI - 1]);
        }

        switch (tokens[opI].charAt(0)) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                return (int) (firstOperand / secondOperand);
            default:
                throw new IllegalStateException();
        }
    }

    private boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        }

        return false;
    }
}
