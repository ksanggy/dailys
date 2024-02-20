class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[right] + numbers[left];
            if(sum == target)
                return new int[] {left + 1, right + 1};
            if(sum > target)
                right--;
            else if(sum < target)
                left++;

        }
        return new int[0];
    }
}