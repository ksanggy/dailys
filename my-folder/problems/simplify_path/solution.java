class Solution {
    public String simplifyPath(String path) {
        // base case
        if(path.isEmpty())
            return "";
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if(dir.equals("..")) { // directing to parent dir so pop
                if (!stack.isEmpty())
                    stack.pop();
            }
            else if(!dir.equals(".") && !dir.isEmpty())
                stack.push(dir);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}