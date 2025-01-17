// import java.util.stream.*;

class Solution {
    // Intuition:
    // to deal with "distinct" and a O(1) lookup, we can think of a Set in java.
    // The algorithm would be to loop through both input arrays and popultae the Set for both
    // to find list of distinct nums. (nums1Set, nums2Set)
    // we would then loop again to populate the answer list.
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return List.of(
                getElementsOnlyInFirst(nums1, nums2), 
                getElementsOnlyInFirst(nums2, nums1)
            );
    }

    private List<Integer> getElementsOnlyInFirst(int[] first, int[] second) {
        // set list
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();

        for(int num : second)
            secondSet.add(num);
        for(int num : first)
            if(!secondSet.contains(num))
                firstSet.add(num);
        return firstSet.stream().toList();
    }
}