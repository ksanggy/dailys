class Solution {
    public String minWindow(String s, String t) {
        // base case - cases where s.length is smaller than t.length or s is empty
        if(s.length() < t.length() || s.isEmpty())
            return "";
        // pre-process t string letter freq
        Map<Character, Integer> letterFreq = new HashMap<>();
        for (char c : t.toCharArray())
            letterFreq.put(c, letterFreq.getOrDefault(c, 0) + 1);
        // variables
        String answer = null;
        int start = 0;
        int found = 0;
        int minWindow = Integer.MAX_VALUE;
        char[] sLetters = s.toCharArray();
        Map<Character, Integer> freqCountMap = new HashMap<>(); // keep track of letter frequencies of the curr window
        for (int end = 0; end < sLetters.length; end++) {
            // update the frequencies of letters in the current window
            freqCountMap.put(s.charAt(end), freqCountMap.getOrDefault(s.charAt(end), 0) + 1);
            // we increment the found counter if and only if we have found a letter in t string && repeat is the same
            if(letterFreq.containsKey(s.charAt(end)) &&
                    freqCountMap.get(s.charAt(end)).equals(letterFreq.get(s.charAt(end)))) {
                found++;
            }
            // we will deal with shrinking the window size once we have found all letter occurrences in s of t.
            while(found == letterFreq.size()) {
                int window = end - start + 1;
                if(window < minWindow) {
                    minWindow = Math.min(minWindow, end - start + 1);
                    answer = s.substring(start, end + 1);
                }
                // update the count of letter freq of the current start pointer
                freqCountMap.put(s.charAt(start), freqCountMap.getOrDefault(s.charAt(start), 0) - 1);
                if(letterFreq.containsKey(s.charAt(start)) &&
                        freqCountMap.get(s.charAt(start)) < letterFreq.get(s.charAt(start))
                ) {
                    found--;
                }
                start++; // shrink the window
            }
        }
        return answer == null? "":answer;
    }
}