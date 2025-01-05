class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        int resultLength = 0;
        
        while(idx < chars.length) {
            int groupLength = 1; // the char group length
            // we will increment the grouplength until we hit a different char
            while(idx + groupLength < chars.length && 
                    chars[idx + groupLength] == chars[idx])
                groupLength++;
            // in place insert of current idx char into the resultLength idx.
            chars[resultLength++] = chars[idx];

            // if groupLength is gt 1 then it means there are more so as per condition, need to add the groupLength value to the char.
            if(groupLength > 1) {
                // instead of doing mod and remainder, just make the numerical value as String then get the char array then loop through it to insert in-place by incrementing the resultLength by 1 until all numerical value is placed.
                for(char c : Integer.toString(groupLength).toCharArray()){
                    chars[resultLength++] = c;
                }
            }
            // move the idx to all the way up after the current group length.
            idx += groupLength;
        }

        return resultLength;
    }
}