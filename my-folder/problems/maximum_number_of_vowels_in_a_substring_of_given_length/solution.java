class Solution {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');
    // Intuition : 
    // First we need to have the vowels held in a container for easy lookup.
    // Using Hashmap will allow for O(1) TC lookup time.
    // Using sliding window method used in max avg. problem
    // can perform O(n) TC.
    public int maxVowels(String s, int k) {
        
        int count = 0;
        for(int i = 0; i < k; i++)
            count += VOWELS.contains(s.charAt(i)) ? 1 : 0;

        int max = count;
        for(int i = k; i < s.length(); i++) {
            count += VOWELS.contains(s.charAt(i)) ? 1 : 0;
            count -= VOWELS.contains(s.charAt(i - k)) ? 1 : 0;
            max = Math.max(max, count);
        }
        return max;
    }
}