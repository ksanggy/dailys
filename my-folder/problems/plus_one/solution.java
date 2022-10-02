class Solution {
    public int[] plusOne(int[] digits) {
        int carryNum = 1;
        for(int i = digits.length -1; i >= 0; i--){
            digits[i] += carryNum;
            if(digits[i] <= 9){
                return digits;
            }
            digits[i] = 0;
        }
        //setting of new return array for carried
        int[] returnArr = new int[digits.length + 1];
        returnArr[0] = carryNum;
        return returnArr;
    }
}