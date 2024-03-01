class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // set up variable of hashmap to hold the character combination as the key and
        // the list of strings as its value
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);
            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            anagramMap.get(sortedStr).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(anagramMap.values());
        return result;
    }
}