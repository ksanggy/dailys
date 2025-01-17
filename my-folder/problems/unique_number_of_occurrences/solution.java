class Solution {
    // Intuition:
    // using of hashmap will keep track of occurrences of the number and allow a faster lookup
    // as the key of the hashmap will be the element value
    // --------
    // interpreted the problem wrong -> we are looking for uniqueness of number of occurrences
    // same as above, using of set can also do.
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for(int num : arr) 
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        
        Set<Integer> uniqueOccurrences = new HashSet<>();
        for(int val : occurrences.values()){
            if(uniqueOccurrences.contains(val))
                return false;
            uniqueOccurrences.add(val);
        }
        return true;
    }
}