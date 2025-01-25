class Solution {
    public String decodeString(String s) {
        Stack<Character> preprocessing = new Stack<>();
        StringBuilder decodedString = new StringBuilder();
        for(Character c : s.toCharArray()) {
            if(c == ']') {
                decodeProcessor(preprocessing);
                continue;
            }
            preprocessing.push(c);
        }
        
        while(!preprocessing.isEmpty())
            decodedString.insert(0, preprocessing.pop());

        return decodedString.toString();
    }

    private void decodeProcessor(Stack<Character> preprocessing) {
        StringBuilder tempStr = new StringBuilder();
        while(preprocessing.peek() != '[')
            tempStr.insert(0, preprocessing.pop());
        preprocessing.pop(); // remove [
        
        int base = 1;
        int k = 0;
        // build the number k repeat
        while(!preprocessing.isEmpty() && Character.isDigit(preprocessing.peek())) {
            k = k + Character.getNumericValue(preprocessing.pop()) * base;
            base *= 10; // in case we have a k number that is a double digit and bigger
        }

        while(k != 0) {
            for(int i = 0; i < tempStr.length(); i++)
                preprocessing.push(tempStr.charAt(i));
            k--;
        }
    }
}