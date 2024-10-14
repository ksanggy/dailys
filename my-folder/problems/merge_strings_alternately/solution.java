class Solution {
    public String mergeAlternately(String word1, String word2) {
        int pointer1 = 0;
        int pointer2 = 0;
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();
        StringBuilder mergedSB = new StringBuilder();
        
        while(pointer1 < word1Chars.length && pointer2 < word2Chars.length) {
            mergedSB.append(word1Chars[pointer1]);
            mergedSB.append(word2Chars[pointer2]);
            pointer1++;
            pointer2++;
        }

        if(pointer1 < word1Chars.length)
            mergedSB.append(word1.substring(pointer1));
        if(pointer2 < word2Chars.length)
            mergedSB.append(word2.substring(pointer2));
        
        return mergedSB.toString();
    }
}