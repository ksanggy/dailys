class Solution {
    public boolean isAnagram(String s, String t) {
       
        Map<String, Long> sResult = Arrays.stream(s.toLowerCase().split(""))
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        
        Map<String, Long> tResult =
                Arrays.stream(t.toLowerCase().split(""))
                        .collect(
                                Collectors.groupingBy(w -> w, Collectors.counting())
                        );
        return sResult.equals(tResult);
    }
}