class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        char[] xCharArray = String.valueOf(x).toCharArray();
        int left = 0;
        int right = xCharArray.length - 1;
        while(left < right) {
            if(xCharArray[left] != xCharArray[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}