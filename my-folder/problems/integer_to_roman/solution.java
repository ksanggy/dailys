class Solution {
    public static String intToRoman(int num) {
        // set up store for in to roman mapping
        int[] intStore = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanStore = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        // StringBuilder for result roman character string
        StringBuilder romanBuilder = new StringBuilder();
        for (int i = 0; i < intStore.length; i++) {
            while(num >= intStore[i]) {
                num -= intStore[i];
                romanBuilder.append(romanStore[i]);
            }
        }
        return romanBuilder.toString();
    }

}