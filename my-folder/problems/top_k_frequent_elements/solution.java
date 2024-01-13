class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(Integer num : nums)
            freqMap.merge(num, 1, Integer::sum);
        for(Integer key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if(bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        int index = 0;
        int[] resultArr = new int[k];
        for(int i = nums.length; i >= 0; i--) {
            if(bucket[i] != null) {
                for(int val : bucket[i]) {
                    resultArr[index++] = val;
                    if(index == k)
                        return resultArr;
                }
            }
        }
        return resultArr;
    }
}