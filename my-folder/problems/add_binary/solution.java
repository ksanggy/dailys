class Solution {
    public String addBinary(String a, String b) {
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;
        int carrier = 0;
        int maxLength = Integer.max(a.length(), b.length());
        String result = "";
        for(int i = 0; i < maxLength; i++){
            int value1 = i < a.length() ? a.charAt(a.length()-1 -i) - '0' : 0;
            int value2 = i < b.length() ? b.charAt(b.length()-1 -i) - '0' : 0;
            int tmp = value1 + value2 + carrier;
            carrier = tmp /2;
            result = tmp % 2 + result;
        }
        return (carrier == 0) ? result : "1" + result;
    }
}