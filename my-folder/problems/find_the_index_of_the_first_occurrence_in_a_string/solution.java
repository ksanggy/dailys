class Solution {
    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int haystackLength = haystack.length();

        if (haystackLength < needleLength) { // Early return for impossible cases
            return -1;
        }

        for (int i = 0; i <= haystackLength - needleLength; i++) { // Loop optimization
            int j = 0;
            while (j < needleLength && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needleLength) { // Match found
                return i;
            }
        }

        return -1; // No match found
    }
}