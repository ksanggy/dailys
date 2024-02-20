class Solution {
    public boolean isSubsequence(String s, String t) {
        int tPointer = 0;
        int sPointer = 0;
        while(tPointer < t.length() && sPointer < s.length()) {
            if(s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
                tPointer++;
            }
            else
                tPointer++;
        }
        return sPointer == s.length();
    }
}