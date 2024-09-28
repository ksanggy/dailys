class Solution {
    public String reverseVowels(String s) {
        Map<Character, Integer> vowels = Map.ofEntries(
            Map.entry('a', 1),
            Map.entry('e', 1),
            Map.entry('i', 1),
            Map.entry('o', 1),
            Map.entry('u', 1),
            Map.entry('A', 1),
            Map.entry('E', 1),
            Map.entry('I', 1),
            Map.entry('O', 1),
            Map.entry('U', 1)
        );

        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        

        while(left < right) {
            char leftChar = chars[left];
            char rightChar = chars[right];

            if(!vowels.containsKey(leftChar)) {
                left++;
                continue;
            }
            if(!vowels.containsKey(rightChar)) {
                right--;
                continue;
            }

            chars[left] = rightChar;
            chars[right] = leftChar;
            left++;
            right--;
        }
        return new String(chars);
    }
}