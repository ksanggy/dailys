class Solution {
    // intuition:
    // since we can collide the planet with asteroids in any arbitrary order,
    // we can greedily reorder the asteroids in ascending order so that the planet
    // can absorb the asteroid, if it can.
    // If an asteroid destroys the planet, then the rest of asteroids will destroy the planet also
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // sort O(nlongn)
        Arrays.sort(asteroids);
        long massSum = mass;
        for(int asteroid : asteroids) {
            if(massSum < asteroid)
                return false;
            massSum += asteroid;
        }
        return true;
    }
}