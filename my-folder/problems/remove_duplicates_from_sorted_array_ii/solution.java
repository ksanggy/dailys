class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 1;
        int k = 1;
        for (int right = 1; right < nums.length; right++) {
            if(nums[right] == nums[right - 1])
                k++;
            else
                k = 1; // reset k as it is a unique value
            if(k < 3)
                nums[left++] = nums[right];
        }
        return left;
    }
}