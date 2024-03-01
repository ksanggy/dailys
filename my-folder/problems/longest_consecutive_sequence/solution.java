class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 1)
            return 0;
        // set up variable of hashmap to hold the element as the key and next number of element as value.
        Map<Integer, Integer> numberMap = new TreeMap<>();
        for (int num : nums) {
            numberMap.put(num, num + 1);
        }

        int counter = 0;
        int answer = 0;
        for (Map.Entry<Integer, Integer> entry : numberMap.entrySet()) {
            if(numberMap.containsKey(entry.getValue()))
                counter++;
            else {
                answer = Math.max(answer, counter + 1);
                counter = 0;
            }
        }
        return answer;
    }
}