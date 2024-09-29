class Solution {
    public String reverseVowels(String s) {
        final String vowels = "aeiouAEIOU";
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        while(left < right) {

            while(left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }

            while(left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
        return new String(chars);
    }
}