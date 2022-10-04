class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int high = x;
        int low = 0;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(mid > x / mid) {
                high = mid -1;
            }else{
                low = mid + 1;
                if(low > x / low){
                    return mid;
                }
            }
        }
        return low;
    }
}