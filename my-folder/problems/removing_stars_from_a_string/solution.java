class Solution {
    // intuition:
    // using of Stack DS to check the prev Char when a "*" is seen.
    // removing both the start and the prev Char.
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(Character curr : s.toCharArray()) {
            if(curr == '*') {
                stack.pop();
                continue;
            }
            stack.push(curr);
        }
        StringBuilder result = new StringBuilder();
        for(Iterator<Character> it = stack.descendingIterator(); it.hasNext();) {
            result.append(it.next());
        }

        return result.toString();
    }
}