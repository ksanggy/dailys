class NumArray {
    // Intuition:
    // thinking of prefix sum for this class design, we can have a member field holding the prefix sum
    // as it is initialized through constructor
    // given range of sum, we can return the sum of the range between left and right of prefix sum arr

    private int[] prefixSumArr;

    public NumArray(int[] nums) {
        prefixSumArr = new int[nums.length]; // initialize prefixSumArr;
        prefixSumArr[0] = nums[0]; // set first elelemnt of prefixSumArr to the first element of input arr ele
        // populate using the input array with calculated prefix sum
        for(int i = 1; i < nums.length; i++)
            prefixSumArr[i] = prefixSumArr[i - 1] + nums[i];
    }
    
    public int sumRange(int left, int right) {  
        // we will return prefixSumArr[right] only if the range sum query starts from 0.
        if(left == 0)
            return prefixSumArr[right];
        else // else, we need to subtract the sum left of the left index (left - 1) from the right index sum
            return prefixSumArr[right] - prefixSumArr[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */