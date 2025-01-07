class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.isBlank())
            return true;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int left = 0;
        int right = 0;
        while(right < t.length()) {
            if(sChars[left] == tChars[right])
                left++;
            if(left >= s.length())
                return true;
            right++;
        }
        return false;
    }
}