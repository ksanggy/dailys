class Solution {
    public static int evalRPN(String[] tokens) {
        // base case
        if(tokens.length < 1)
            return 0;
        // set up stack ds to hold the integer values to be popped later when operator is hit
        Stack<Integer> stack = new Stack<>();
        // loop through
        for (String token : tokens) {
            if(isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int value = evaluate(operand1, operand2, token);
                stack.push(value);
            }
            else
                stack.push(Integer.parseInt(token));
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }

    private static int evaluate(int op1, int op2, String operator) {
        return switch (operator) {
            case "/" -> op1 / op2;
            case "*" -> op1 * op2;
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            default -> 0;
        };
    }

    private static boolean isOperator( String token) {
        return token.equals("/") || token.equals("*") || token.equals("+") || token.equals("-");
    }
}