class Solution {
    public boolean isValid(String s) {
        // base case
        if(s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketLookup = new HashMap<>();
        // setup lookup table with key being the closing parenthesis
        bracketLookup.put(')', '(');
        bracketLookup.put('}', '{');
        bracketLookup.put(']', '[');
        for (char c : s.toCharArray()) {
            if(bracketLookup.containsKey(c)) {
                // you are adding to stack only opening parenthesis
                //  if the current character is in bracketLookup
                // (which key holds the closing) then stack.peek() need to == the value of lookup
                if(!stack.isEmpty() && bracketLookup.get(c).equals(stack.peek()))
                    stack.pop(); // remove from stack as we have found the pair
                else
                    return false;
            } else
                stack.push(c);
        }
        return stack.isEmpty(); // if valid, stack needs to be empty
    }
}