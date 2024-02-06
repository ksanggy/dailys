class Solution {
    static Map<Character, Integer> romanNumMap = new HashMap<>(
            Map.of(
                    'I', 1,
                    'V', 5,
                    'X', 10,
                    'L', 50,
                    'C', 100,
                    'D', 500,
                    'M', 1000
            ));

    public static int romanToInt(String s) {
        int sum = 0;
        int prev = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            int currVal = romanNumMap.get(s.charAt(i));
            if(prev < currVal) {
                sum -= prev; // correct the wrongly added value from the sum
                sum += currVal - prev; // add the correct value of the special cases
            }
            else
                sum += currVal;
            prev = currVal; // update the prev value to current value
        }
        return sum;
    }
}