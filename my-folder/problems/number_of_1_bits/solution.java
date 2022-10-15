public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String unsignedStr = Integer.toUnsignedString(n, 2);
        int cnt = 0;
        for(int i = 0; i < unsignedStr.length(); i++){
            if(String.valueOf(unsignedStr.toCharArray()[i]).equals("1")) cnt+=1;    
        }
        return cnt;
    }
}