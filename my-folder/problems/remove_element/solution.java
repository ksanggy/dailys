class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        if(nums.length == 0) return 0;
        if(val < 0 || val > 100) return 0;

        for(int i = 0; i <= nums.length-1; i++){
            if(nums[i] == val){
                nums[index] = nums[i];
            }else{
                nums[index] = nums[i];
                index +=1;
            }
        }
        return index;
    }
}