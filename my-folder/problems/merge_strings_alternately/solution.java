class Solution {
    public String mergeAlternately(String word1, String word2) {
        int word1Length = word1.length() - 1;
        int word2Length = word2.length() - 1;
        int lengthToLoop = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= lengthToLoop; i++) {
            if(i > word1Length) {
                sb.append(word2.substring(i, word2Length + 1));
                break;
            }    
            if(i > word2Length) {
                sb.append(word1.substring(i, word1Length + 1));
                break;
            }
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        return sb.toString();
    }
}