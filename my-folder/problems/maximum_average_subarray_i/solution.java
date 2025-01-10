class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        // first loop will get the first k length of sum
        for(int i = 0; i < k; i++)
            sum += nums[i];

        // second loop will add the next element and remove the last element value from the sum
        // compare if it is the maxSum
        double maxSum = sum;
        for(int i = k; i < nums.length; i++) {
            // we add to the sum the value of current element value - the value of the begininning of the first subarray element in the previous run.
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        // return the max avg
        return maxSum/k;
    }
}