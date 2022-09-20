class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int prevValue = 0;
        
        for(int i = 0; i < s.length(); i++){
            int currValue = convertRomanToNumber(s.charAt(i));
            
            //if prevValue is less than current value then it means it's one of the 3 special cases
            if(prevValue < currValue){
                sum -= prevValue;
                sum += currValue - prevValue; //correct value added to total
            }else {
                sum += currValue;
            }
            prevValue = currValue; //setting of prevValue to be used for next value
        }
        return sum;
    }
    
    //converts roman numeral to actual int value
    public int convertRomanToNumber(Character romanNum){
        switch(romanNum){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : throw new Error("Not valid roman numeral");    
        }
    }
}