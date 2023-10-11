class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        int left = 0;
        int right = nums2.length - 1;
        List<Integer> intersections = new ArrayList<>();
        while(left <= right) {
            if(set.contains(nums2[left]) && !intersections.contains(nums2[left])) intersections.add(nums2[left]);
            if(set.contains(nums2[right]) && !intersections.contains(nums2[right])) intersections.add(nums2[right]);
            left++;
            right--;
        }
        return intersections.stream().mapToInt(Integer::intValue).toArray();
    }
}