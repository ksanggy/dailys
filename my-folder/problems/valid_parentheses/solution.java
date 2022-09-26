class Solution {
    public boolean isValid(String s) {
        Stack<Character> stackedChars = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char item;
            char theChar = s.charAt(i);

            if(theChar == '(' || theChar == '{' || theChar == '['){
                stackedChars.push(theChar);
            }else {
                try{
                    item = stackedChars.pop();
                } catch(Exception e){
                    return false;
                }

                if((theChar ==')' && item != '(') || (theChar == '}' && item != '{') || (theChar == ']' && item != '[')){
                    return false;
                }
            }
        }
        return stackedChars.isEmpty();
    }
}