class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(String operation : operations){
            if(operation.contains("--")){
                ans -= 1;
            }
            if(operation.contains("++")){
                ans += 1;
            }
        }
        return ans;
    }
}