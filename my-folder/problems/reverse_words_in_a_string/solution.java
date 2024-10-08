class Solution {
    public String reverseWords(String s) {
        Deque<String> stack = new ArrayDeque<>();
        String[] splittedString = s.trim().split(" ");

        for (String word : splittedString) {
            if(!word.isBlank())
                stack.push(word);
        }
        return String.join(" ", stack);
    }
}