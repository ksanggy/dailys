class Solution {
    public int evalRPN(String[] tokens) {
        // go through the tokens and add to stack until you hit operand (+, -, *, /)
        // resolve the operand by popping elements from the stack (stack will only hold the operators)
        Stack<Integer> operators = new Stack<>();
        for(String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int operator1 = operators.pop();
                int operator2 = operators.pop();
                operators.add(calculate(operator1, operator2, token));
            }
            else
                operators.add(Integer.parseInt(token));
        }
        return operators.pop();
    }

    private static int calculate( int operator1, int operator2, String operand ) {
        return switch (operand) {
            case "+" -> operator2 + operator1;
            case "-" -> operator2 - operator1;
            case "*" -> operator2 * operator1;
            case "/" -> operator2 / operator1;
            default -> 0;
        };
    }
}