class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> wordMap1 = new HashMap<>();
        Map<Character, Integer> wordMap2 = new HashMap<>();

        for(char key : word1.toCharArray())
            wordMap1.put(key, wordMap1.getOrDefault(key, 0) + 1);
        for(char key : word2.toCharArray())
            wordMap2.put(key, wordMap2.getOrDefault(key, 0) + 1);

        if(!wordMap1.keySet().equals(wordMap2.keySet()))
            return false;
        
        List<Integer> word1Freqs = new ArrayList<>(wordMap1.values());
        List<Integer> word2Freqs = new ArrayList<>(wordMap2.values());
        Collections.sort(word1Freqs);
        Collections.sort(word2Freqs);
        return word1Freqs.equals(word2Freqs);
    }
}