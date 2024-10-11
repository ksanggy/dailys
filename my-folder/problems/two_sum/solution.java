class Solution {
    public int[] twoSum(int[] nums, int target) {
        // no need to validate the input arr since length is always greater than or equal to 2.
        // and one valid answer always exists.

        // we use complements to check if it already exists in the hashmap of nums[i] with index i as value.
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // check if complement exists in hashmap, return indices if exists
            if(hm.containsKey(complement))
                return new int[] {hm.get(complement), i};
            hm.put(nums[i], i);
        }
        return new int[]{};
    }
}