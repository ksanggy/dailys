class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 1. sort the arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 2. set up two pointers
        int nums1Left = 0;
        int nums2Left = 0;
        // 3. result array to return
        List<Integer> list = new ArrayList<>();
        while(nums1Left < nums1.length && nums2Left < nums2.length) {
            if(nums1[nums1Left] < nums2[nums2Left]) // increment the pointer of the element that is smaller
                nums1Left++;
            else if(nums1[nums1Left] > nums2[nums2Left]) // increment the pointer of the element that is smaller
                nums2Left++;
            else { // if both elements are equal, add the element to result list and increment both pointers
                list.add(nums1[nums1Left]);
                nums1Left++;
                nums2Left++;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }
}