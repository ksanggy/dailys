class Solution {
    List<String> result = new ArrayList<>();
    Stack<Character> stack = new Stack<>();
    public List<String> generateParenthesis( int n) {
        backtrack(0, 0, n);
        return result;
    }

    private void backtrack( int openCnt, int closeCnt, int n ) {
        if(openCnt == closeCnt && closeCnt == n) {
            Iterator<Character> stackItr = stack.iterator();
            StringBuilder sb = new StringBuilder();
            while(stackItr.hasNext())
                sb.append(stackItr.next());
            result.add(sb.toString());
        }
        if(openCnt < n) {
            stack.push('(');
            backtrack(openCnt + 1, closeCnt, n);
            stack.pop();
        }
        if(closeCnt < openCnt) {
            stack.push(')');
            backtrack(openCnt, closeCnt + 1, n);
            stack.pop();
        }
    }
}