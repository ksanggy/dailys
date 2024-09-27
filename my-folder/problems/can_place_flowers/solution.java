class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowerbedSize = flowerbed.length;
        
        for(int i = 0; i < flowerbedSize; i++) {
            int left = i == 0 ? 0 : flowerbed[i - 1];
            int right = i == flowerbedSize - 1 ? 0 : flowerbed[i + 1];

            if(left + flowerbed[i] + right == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}