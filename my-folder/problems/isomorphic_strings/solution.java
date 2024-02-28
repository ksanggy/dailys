class Solution {
    public boolean isIsomorphic(String s, String t) {
        // base case
        if(s.length() != t.length())
            return false;
        // set variable
        // implement hash table using arrays of 128 lengths
        int[] sHashTable = new int[128];
        int[] tHashTable = new int[128];
        // remember the definition of isomorphic strings
        // Two strings s and t are isomorphic if the characters in s can be replaced to get t.
        for (int i = 0; i < s.length(); i++) {
            char sCharacter = s.charAt(i);
            char tCharacter = t.charAt(i);
            if(sHashTable[sCharacter] != tHashTable[tCharacter])
                return false;
            sHashTable[sCharacter] = i + 1;
            tHashTable[tCharacter] = i + 1;
        }
        return true;
    }
}