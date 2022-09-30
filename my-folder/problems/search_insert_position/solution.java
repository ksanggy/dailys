class Solution {
    public int searchInsert(int[] nums, int target) {
        int startIdx = 0;
        int endIdx = nums.length -1;

        while(startIdx <= endIdx){
            int midIdx = startIdx + (endIdx - startIdx)/2;
            if(nums[midIdx] == target) return midIdx;

            if(target > nums[midIdx]) startIdx = midIdx +1;
            else endIdx = midIdx -1;
        }
        return startIdx;
    }
}