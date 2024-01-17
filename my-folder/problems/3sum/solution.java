class Solution {
    public static List<List<Integer>> threeSum( int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>(); // the list of triplets that will be returned as a result
        // sort the array first
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // skip repeating values
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            searchPair(nums, -nums[i], i + 1, triplets);
        }
        return triplets;
    }

    private static void searchPair( int[] nums, int target, int left, List<List<Integer>> triplets ) {
        List<Integer> triplet = new ArrayList<>();
        int right = nums.length - 1;
        while(left < right) {
            int pairSum = nums[left] + nums[right];
            if(pairSum == target) {
                triplets.add(Arrays.asList(-target, nums[left], nums[right]));
                left++;
                right--;
                while(left < right && nums[left] == nums[left-1]) left++;
                while(left < right && nums[right] == nums[right+1]) right--;
            }
            else if(pairSum < target)
                left++;
            else
                right--;
        }
    }
}