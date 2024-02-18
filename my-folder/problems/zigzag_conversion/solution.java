class Solution {
    public String convert(String s, int numRows) {
        if(s.isEmpty() || numRows == 1)
            return s;
        // set up variables
        StringBuilder[] rowStringBuilder = new StringBuilder[numRows];
        for (int i = 0; i < rowStringBuilder.length; i++) {
            rowStringBuilder[i] = new StringBuilder();
        }
        boolean reverse = false;
        int currentRow = 0;
        for (int i = 0; i < s.length(); i++) {
            rowStringBuilder[currentRow].append(s.charAt(i));
            if(reverse)
                currentRow--;
            else
                currentRow++;
            if(currentRow == 0 || currentRow == numRows - 1)
                reverse = !reverse;
        }
        return String.join("", rowStringBuilder);
    }
}