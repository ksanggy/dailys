class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        // pre-processing to store a word frequency map
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words)
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);

        // calculate window size
        int wordLength = words[0].length();
        int windowSize = wordLength * words.length;
        for (int start = 0; start <= s.length() - windowSize; start++) {
            // use util method to check if the current substring contains all lists of words
            String substring = s.substring(start, start + words.length * wordLength);
            isConcatenated(substring, wordLength, start, words, wordMap, result);
        }
        return result;
    }

    private static void isConcatenated( String currWindow,
                                        int wordLength,
                                        int windowStartIdx,
                                        String[] words,
                                        Map<String, Integer> wordMap,
                                        List<Integer> result ) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int nextWordIdx = i * wordLength;
            String word = currWindow.substring(nextWordIdx, nextWordIdx + wordLength);
            if (!wordMap.containsKey(word) || wordMap.get(word) <= 0)
                return;
            else {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
                if(freqMap.get(word) > wordMap.get(word))
                    return;
            }
        }
        result.add(windowStartIdx);
    }
}