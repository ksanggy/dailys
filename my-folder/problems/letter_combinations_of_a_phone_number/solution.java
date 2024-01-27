class Solution {
    private static final Map<Character, String> mapOfLetters = Map.of(
         '2', "abc",
         '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );
    public List<String> letterCombinations(String digits) {
        List<String> resultString = new ArrayList<>();
        // based on the requirement if empty 'digits' is given, return empty list
        if(digits.isEmpty())
            return resultString;
        // use backtracking to find all letter combinations for the 'digits' given
        backtrack(0, digits, "", resultString);
        return resultString;
    }

    private static void backtrack( int index, String digits, String currString, List<String> resultString ) {
        // 'digits' length is the max letter combination length.
        // thus, if currString (the letter combination) length is equal to 'digits' length,
        // then we found the combination
        if(currString.length() == digits.length()) {
            resultString.add(currString);
            return;
        }
        else if (index >= digits.length()) { // invalid index (base case)
            return;
        } else {
            // this is where we will use bruteforce to find the next combination
            // we get the letters from the map using the digit
            String digit = mapOfLetters.get(digits.charAt(index));
            // loop through the letters that is mapped to the digit and backtrack recursively by
            // passing on the next index, the currString (it will append the character of each letter combination),
            // and the resultString so that it can build on to the answer String.
            for (char c : digit.toCharArray()) {
                backtrack( index + 1, digits, currString + c, resultString);
            }
        }
    }
}