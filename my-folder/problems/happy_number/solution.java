class Solution {
    public boolean isHappy(int n) {
        // 1. setup pointers
        int slow = n;
        int fast = n;
        // 2. process the pointers, having fast move 2 steps ahead (squaring twice)
        do {
            slow = findSquare(slow); // move one step
            fast = findSquare(findSquare(fast)); // move two steps ahead
        } while(slow != fast); // found cycle
        return slow == 1;
    }

    private int findSquare(int num) {
        int sum = 0;
        int digit = -1;
        while(num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}