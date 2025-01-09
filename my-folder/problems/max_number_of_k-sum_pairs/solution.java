class Solution {
    // Intuition:
    // an operation includes -> find sum of two #, check if equal to k, remove if equal to k
    // remove doesn't have to be an actual physical remove since we don't need to return an array
    // (WRONG INUTITION: Also, thought about sorting, but sorting won't really do much as we only return number of oper.)
    // sortin the array and applying appropriate conditions when moving pointers will help.
    // we can do this in single run using two-pointers (since adding two numbers)
    public int maxOperations(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int operCount = 0;
        Arrays.sort(nums); // sort the input array 
        while(left < right) {
            // find sum of two nums
            int sum = nums[left] + nums[right];
            // check if sum == k, if it does increment operation count "operCount" by 1
            if(sum == k) {
                operCount++;
                left++;
                right--;
            }
            if(sum < k)
                left++;
            if(sum > k)
                right--;
        }
        return operCount;
    }
}