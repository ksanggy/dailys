class Solution {
    public int hIndex(int[] citations) {
        int totalPapers = citations.length;
        int[] lookup = new int[totalPapers + 1];
        for (int citationCount : citations) {
            if(citationCount > totalPapers)
                lookup[totalPapers]++;
            else
                lookup[citationCount]++;
        }
        int result = 0;
        for (int i = totalPapers; i >= 0; i--) {
            result += lookup[i];
            if(result >= i)
                return i;
        }
        return 0;
    }
}