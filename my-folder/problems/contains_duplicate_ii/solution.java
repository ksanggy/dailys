class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(var i = 0; i < nums.length; i++){
            var value = nums[i];
            if(map.containsKey(value)) {
                int currIdx = i;
                if(Math.abs(map.get(value) - currIdx) <= k) {
                    System.gc();
                    return true;
                }
                // map.get(value).add(i);
                
            }
            // List<Integer> indeces = new ArrayList<>();
            // indeces.add(i);
            map.put(value, i);
        }
        System.gc();
        return false;
    }
}