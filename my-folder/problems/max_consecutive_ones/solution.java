class Solution {
    // INTUTITION:
    // Use Sliding window to track a window of consecutive 1s.
    // We also don't need to have variables that track the count of 1s in a window
    // as we can use start and end pointers to find the length of 1s in a window.
    // window will increase by using for loop but will reset left pointer window (shrink) if it hits a 0.
    // If 0 is seen, we reset the max length of consecutive 1s as result.
    // -----------------
    // initially, thought having the end pointer as inner var of for loop would work,
    // but end var also needs to be accessible in method scope as there are cases where last element
    // can be a non-zero
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int start = 0;
        int end;
        for(end = 0; end < nums.length; end++) {
            if(nums[end] == 0) {
                max = Math.max(max, end - start);
                start = end + 1;
            }
        }
        max = Math.max(max, end - start);
        return max;
    }
}