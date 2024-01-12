class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> characterFrequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            characterFrequency.put(s.charAt(i), characterFrequency.getOrDefault(s.charAt(i), 0) + 1);
            characterFrequency.put(t.charAt(i), characterFrequency.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (Character c : characterFrequency.keySet()) {
            if(characterFrequency.get(c) != 0)
                return false;
        }
        return true;
    }
}