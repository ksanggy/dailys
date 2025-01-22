class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>(); // basically instead of using stack to track characters, we are tracking the count of the repeats of the character
        for(int i = 0; i < sb.length(); ++i) {
            if(i == 0 || sb.charAt(i) != sb.charAt(i-1)) {
                counts.push(1); // we are putting in new count for current index character
            }
            else {
                int incremented = counts.pop() + 1; // Integer in java is immutable, so must pop first, increment then add.
                if(incremented == k) { // if the incrementation for the character is equal to k
                    sb.delete(i - k + 1, i + 1); // (inclusive, exclusive)
                    i = i - k; // -> setting the i back to the position after dups were removed
                }
                else {
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}