class Solution {
    public void moveZeroes(int[] nums) {
        int[] resultArr = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                resultArr[left] = nums[i];
                left++;
            }
            else {
                resultArr[right] = nums[i];
                right--;
            }
        }
        System.arraycopy(resultArr, 0, nums, 0, nums.length);   
    }
}