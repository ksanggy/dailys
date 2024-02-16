class Solution {
    public String reverseWords(String s) {
        Stack<String> reversedWords =new Stack<>();
        String[] splitWords = s.split(" ");
        for (String word : splitWords) {
            if(word.isBlank())
                continue;
            reversedWords.add(word);
        }
        StringBuilder result = new StringBuilder();
        while(!reversedWords.isEmpty()) {
            result.append(" ");
            result.append(reversedWords.pop());
        }
        return result.toString().trim();
    }
}