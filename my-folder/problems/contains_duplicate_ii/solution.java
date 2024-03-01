class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // base case
        if(nums.length < 2)
            return false;
        // set up variable to hold element index to element value
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // check if value exists in the 'valueIndexMap', and if it does do abs(i-j) calculation to check if <= k.
            // return true if calculated difference in abs value is <= k
            if(valueIndexMap.containsKey(num) && Math.abs(i - valueIndexMap.get(num)) <= k)
                return true;
            // place the current value as key and index as its value into the 'valueIndexMap'
            valueIndexMap.put(num, i);
        }
        return false;
    }
}