class Solution {
    public boolean isValid(String s) {
        // base case, as parentheses' are pairs, % 2 != 0 will not be valid
        if(s.length() % 2 != 0)
            return false;
        Map<Character, Character> bracketLookup = new HashMap<>();
        // setup lookup table with key being the closing parenthesis
        bracketLookup.put(')', '(');
        bracketLookup.put('}', '{');
        bracketLookup.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(!stack.isEmpty() && bracketLookup.containsKey(c) && stack.peek() == bracketLookup.get(c))
                stack.pop();
            else if(!stack.isEmpty() && bracketLookup.containsKey(c) && stack.peek() != bracketLookup.get(c))
                return false;
            else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}