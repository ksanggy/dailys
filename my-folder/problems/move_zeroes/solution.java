class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1)
            return;
        int left = 0; // the non-zero index
        
        // this moves all the non-zero element to the front
        for(int num : nums) {
            if(num != 0) {
                nums[left] = num;
                left++;
            }
        }

        // if left pointer is not at the end of the nums.length -> change the remaining elements to 0
        // this is because you have already moved non-zero elements in the first loop
        while(left != nums.length) {
            nums[left] = 0;
            left++;
        }
    }
}