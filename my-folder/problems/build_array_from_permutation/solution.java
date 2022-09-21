class Solution {
    public int[] buildArray(int[] nums) {
        //check constrain 1 <= nums.length <= 1000
        if(nums.length > 1000) { return null; }
        int[] ans = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
        
    }
}