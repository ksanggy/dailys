class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        Arrays.sort(strs);
        int index = 0;
        String lastIndexWord = strs[strs.length - 1];
        while(index < strs[0].length() && index < lastIndexWord.length()) {
            if(strs[0].charAt(index) == lastIndexWord.charAt(index))
                index++;
            else
                break;
        }
        return strs[0].substring(0, index);
    }
}