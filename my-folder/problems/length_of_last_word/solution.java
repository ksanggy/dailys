class Solution {
    public int lengthOfLastWord(String s) {
        String trimmedString = s.trim();
        int lastSpaceIndex = trimmedString.lastIndexOf(' ');
        int lastIndex = trimmedString.length() - 1;
        if(lastSpaceIndex == -1)
            return lastIndex + 1; // there is no space making the whole string a single word (the last word)
        // 'lastSpaceIndex' will be just before the last word
        else
            return lastIndex - lastSpaceIndex;
    }
}