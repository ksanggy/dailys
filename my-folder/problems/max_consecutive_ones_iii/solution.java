class Solution {
    // Intuition:
    // flip only 0s and only increase the window when it is a consecutive 1s in the window
    // increment count when flipping 0, once count == k, then reset the value and the window 
    // --------------------------
    // above thoughts are initia thoughts,
    // let's change the thoguth process a little blt -> just count the 0s but be flexible in expanding or shrinking the window size.
    // we can shirnk the window if we hit 0s = k until we hit a 1 and not > k.
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right;
        for (right = 0; right < nums.length; right++) {
            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[right] == 0) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
            if (k < 0) {
                // If the left element to be thrown out is zero we increase k.
                if(nums[left] == 0)
                    k++;
                left++;
            }
        }     
        return right - left;
    }
}