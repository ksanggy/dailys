class Solution {
    public boolean isPalindrome(int x) {
        int originalNum = x;
        int reversedNum = 0;
        if(originalNum < 0 || (x%10 == 0 && x != 0)) return false;
        while(originalNum != 0){
            int remainder = originalNum % 10;
            reversedNum = reversedNum * 10 + remainder;
            originalNum /= 10; 
        }
        if(reversedNum == x){
            return true;
        }
        return false;
    }
}