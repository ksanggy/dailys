class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length; // in case nums is less than or equal to k
        reverse(nums, 0, nums.length - 1); // reverse the whole array
        reverse(nums, 0, k - 1); // reverse k elements
        reverse(nums, k, nums.length - 1); // reverse remaining elements
    }

    private static void reverse( int[] nums, int start, int end ) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}