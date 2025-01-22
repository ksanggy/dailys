class Solution {
    // intuition:
    // using of deque DS in java to do the following
    // 1. check if previous element is a duplicate of the current element -> remove
    // 2. if duplicates were removed and we move to the next element, check whether the
        // now previous element is a dup of the now current element.
    // do this until we do not have any adjacent dups
    // return the deque as a string -> note we need to reverse the order to return as original order
    public String removeDuplicates(String s) {
        // init
        Deque<Character> deque = new ArrayDeque<>();

        for(Character letter : s.toCharArray()) {
            if(deque.peek() == letter) {
                while(deque.peek() == letter && !deque.isEmpty())
                    deque.pop();
                continue;
            }
            deque.push(letter);
        }
        StringBuilder sb = new StringBuilder();
        for(Iterator<Character> charItr = deque.descendingIterator(); charItr.hasNext();)
            sb.append(charItr.next());
        return sb.toString();
    }
}