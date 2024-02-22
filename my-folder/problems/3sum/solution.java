class Solution {
    public static List<List<Integer>> threeSum( int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>(); // the list of triplets that will be returned as a result
        // sort the array first
        Arrays.sort(nums); // this is O(nlogn)
        // loop through every element and search for pair that equates to the current element of below loop
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            searchPair(nums, -nums[i], i + 1, triplets);
        }
        return triplets;
    }

    private static void searchPair( int[] nums, int target, int left, List<List<Integer>> triplets ) {
        int right = nums.length - 1;
        while(left < right) {
            int currSum = nums[left] + nums[right];
            if(currSum == target) {
                triplets.add(Arrays.asList(-target, nums[left], nums[right]));
                left++;
                right--;
                while(left < right && nums[left] == nums[left - 1])
                    left++;
                while(left < right && nums[right] == nums[right + 1])
                    right--;
            }
            else if(currSum < target) {
                left++;
            }
            else {
                right--;
            }
        }
    }
}