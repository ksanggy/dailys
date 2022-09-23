class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(nums[i] < nums[j] && i < j){
                    int tmp = nums[j] - nums[i];
                    if(ans < tmp){
                        ans = tmp;
                    }
                }
                
            }
        }
        return ans;
    }
}