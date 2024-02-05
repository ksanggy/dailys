class Solution {
    public int characterReplacement(String s, int k) {
        // two variables for sliding window approach
        int start = 0;
        int end = 0;
        // track current window's character frequency
        int[] freqCount = new int[26];
//        Map<Character, Integer> freqMap = new HashMap<>();

        int maxCharacterCount = 0; // this count is for current window character count
        int result = 0; // the result to return (the longest repeating character)

        while(end < s.length()) {
            char current = s.charAt(end);
            // update the freqMap && maxCharacterCount variables
            freqCount[current - 'A']++;
//            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
            maxCharacterCount = Math.max(maxCharacterCount, freqCount[current - 'A']);

            // check if we have used up replacement count 'k'
            while(end - start + 1 - maxCharacterCount > k) {
                // we need to decrement the count of the character that is removed from the window
                freqCount[s.charAt(start) - 'A']--;
//                freqMap.put(s.charAt(start), freqMap.get(s.charAt(start)) - 1);
                // we also need to shrink the window
                start++;
            }
            // update the result variable with the current window size
            result = Math.max(result, end - start + 1);
            // widen the window
            end++;
        }
        return result;
    }
}