class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        // base case
        if(words.length != pattern.length())
            return false;
        // set up hashmap variable
        Map<Character, String> patterWordMap = new HashMap<>();
        Map<String, Character> patternMap = new HashMap<>();
        // loop through for pattern checking
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char c = pattern.charAt(i);
            if((patterWordMap.containsKey(c) && !patterWordMap.get(c).equals(word)) ||
                    (patternMap.containsKey(word) && !patternMap.get(word).equals(c)))
                return false;
            // map pattern to word
            patterWordMap.put(c, word);
            patternMap.put(word, c);
        }
        return true;
    }
}