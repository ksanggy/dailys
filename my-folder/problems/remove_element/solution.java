class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        if(nums.length == 0) return 0;
        if(val < 0 || val > 100) return 0;

        for(int i = 0; i <= nums.length-1; i++){
            if(nums[i] == val){
                nums[idx] = nums[i];
            }else{
                nums[idx] = nums[i];
                idx ++;
            }
        }
        return idx;
    }
}