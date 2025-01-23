class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> result = new Stack<>();
        for(int asteroid : asteroids) {
            boolean flag = true;
            while(!result.isEmpty() && (result.peek() > 0 && asteroid < 0)) {
                if(Math.abs(result.peek()) < Math.abs(asteroid)) {
                    result.pop();
                    continue;
                }
                else if(Math.abs(result.peek()) == Math.abs(asteroid))
                    result.pop();
                
                flag = false;
                break;
            }

            if(flag)
                result.push(asteroid);
        }

        int[] remaining = new int[result.size()];
        for(int i = remaining.length - 1; i >= 0; i --) {
            remaining[i] = result.pop();
        }
            
        return remaining;
    }
}