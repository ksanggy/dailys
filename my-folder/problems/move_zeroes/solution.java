class Solution {
    // Optimal solution for both space and time
    public void moveZeroes(int[] nums) {
        // tracking the last non zero idx (front of arr)
        int lastNonZeroIdx = 0;
        // loop through nums and just sawp the non zero to the correct idx using lastNonZeroIdx
        // which is the beginning of the input arr.
        // we are also doing an in-place swap 
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, lastNonZeroIdx++, i);
            }       
        }
    } 

    private void swap(int[] nums, int x, int y) {
        int temp = nums[y];
        nums[y] = nums[x];
        nums[x] = temp;
    }
}