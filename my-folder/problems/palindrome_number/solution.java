class Solution {
    public boolean isPalindrome(int x) {
        String tempNumString = String.valueOf(x);

        //reverse
        StringBuffer sb = new StringBuffer(tempNumString);
        String reversedStrNum = sb.reverse().toString();
        return tempNumString.compareTo(reversedStrNum) == 0;
    }
}