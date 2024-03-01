class Solution {
    public static boolean isHappy(int n) {
        // base case
        if(n < 1)
            return false;
        int slow = n;
        int fast = n;
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while( slow != fast );
        return slow == 1;
    }

    private static int findSquare( int n ) {
        int sum = 0;
        int digit = -1;
        while(n > 0) {
            digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}