class Solution {
    public static List<List<Integer>> threeSum( int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>(); // the list of triplets that will be returned as result

        //sort the array
        Arrays.sort(nums); // TIME COMPLEXITY of sorting is O( N * log(N) )
        for (int i = 0; i < nums.length - 2; i++) { // arr.length - 2 because within the search pair method, it will need to compare with the last index value as well.
            if(i > 0 && nums[i] == nums[i-1]) continue; // skip if it is not 0 AND the curr value and prev value is equal
            searchPair(nums, -nums[i], i + 1, triplets); // search the other two pairs and complete the triplet
        }
        return triplets;
    }

    private static void searchPair( int[] arr, int target, int left, List<List<Integer>> triplets ) {
        int right = arr.length - 1;
        while(left < right) {
            int currSum = arr[left] + arr[right];
            if(currSum == target) {
                triplets.add(Arrays.asList(-target, arr[left], arr[right]));
                left++;
                right--;
                while(left < right && arr[left] == arr[left - 1]) left++; // skip any elements of duplicate values
                while(left < right && arr[right] == arr[right + 1]) right--; // skip any elements of duplicate values
            } else if(currSum > target) {
                right--;
            }else{
                left++;
            }
        }
    }
}