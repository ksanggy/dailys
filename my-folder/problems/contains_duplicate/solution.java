class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (Integer num : nums) {
            if (uniques.contains(num))
                return true;
            uniques.add(num); 
        }
        return false;
    }
}