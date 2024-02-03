class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // length of nums1 with actual values (the none 0s)
        int j = n - 1; // length of nums2
        int k = nums1.length - 1; // this the actual length of the merged array m + n

        // The plan is to merge and place values from the end since the two input arrays are sorted
        while(j >= 0) {
            // if 'nums1' value is greater, then place the nums1 value in nums1[k--] index then decrement by 1
            if(i >= 0 && nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            // else, then place the nums2 value in nums1[k--] index then decrement by 1
            else
                nums1[k--] = nums2[j--];
        }
    }
}