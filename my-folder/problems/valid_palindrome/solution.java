class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            // increment left pointer to skip characters that are non alphanumeric
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // increment right pointer to skip characters that are non alphanumeric
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
}