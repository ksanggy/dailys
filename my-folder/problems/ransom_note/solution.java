class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // base case
        if(ransomNote.isEmpty() || magazine.isEmpty())
            return false;

        // set up required variables
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // pre-process magazine string to keep track of the frequency of repeats of letters
        for (char letter : magazine.toCharArray())
            frequencyMap.put(letter, frequencyMap.getOrDefault(letter, 0) + 1);
        // we will loop through ransomNote string per char to determine if it exists in magazine
        // as well as, the repeats are the same.
        for (char c : ransomNote.toCharArray()) {
            if(!frequencyMap.containsKey(c) || frequencyMap.get(c) == 0)
                return false;
            // decrement frequency count of the char c in frequencyMap
            frequencyMap.put(c, frequencyMap.get(c) - 1);

        }
        return true;
    }
}