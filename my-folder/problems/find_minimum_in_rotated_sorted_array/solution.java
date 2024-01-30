class Solution {
    public int findMin(int[] nums) {
        // setup pointers
        int left = 0;
        int right = nums.length - 1;
        // loop to find min
        while(left <= right) {
            // if left pointer value is less than or equal to right pointer value, then we have found the min
            // return the left pointer value
            if(nums[left] <= nums[right])
                return nums[left];
            // get the mid-value of the array
            int middle = (left + right) / 2;

            if(nums[middle] >= nums[left])
                left = middle + 1;
            else
                right = middle;
        }
        return  0;
    }
}