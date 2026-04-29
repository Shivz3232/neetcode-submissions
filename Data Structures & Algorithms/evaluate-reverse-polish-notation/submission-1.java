class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].length() == 1 && isOperator(tokens[i].charAt(0))) {
                int secondOperand = Integer.parseInt(stack.pop());
                int firstOperand = Integer.parseInt(stack.pop());

                switch (tokens[i].charAt(0)) {
                    case '+':
                        stack.push(Integer.toString(firstOperand + secondOperand));
                        break;
                    case '-':
                        stack.push(Integer.toString(firstOperand - secondOperand));
                        break;
                    case '*':
                        stack.push(Integer.toString(firstOperand * secondOperand));
                        break;
                    case '/':
                        stack.push(Integer.toString((int) (firstOperand / secondOperand)));
                        break;
                }
            } else {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private int evaluate(String[] tokens, int opI) {
        int secondOperand;
        if (tokens[opI - 1].length() == 1 && isOperator(tokens[opI - 1].charAt(0))) {
            secondOperand = evaluate(tokens, opI - 1);
        } else {
            secondOperand = Integer.parseInt(tokens[opI - 1]);
        }

        int firstOperand;
        if (tokens[opI - 2].length() == 1 && isOperator(tokens[opI - 2].charAt(0))) {
            firstOperand = evaluate(tokens, opI - 2);
        } else {
            firstOperand = Integer.parseInt(tokens[opI - 2]);
        }

        System.out.println(firstOperand + tokens[opI] + secondOperand);

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
