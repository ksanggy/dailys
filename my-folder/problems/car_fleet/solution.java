class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // just base case
        if(position.length <= 1)
            return 1;
        // create a new 2d array to hold both position & speed
        // sort the 2d array by the position
        int[][] cars = new int[position.length][2]; // [i][] - index, [][0] - position , [][1] - speed
        // stack to hold the individual fleet (it holds the timeToTarget value)
        Stack<Double> fleetStack = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            cars[i] = new int[] {position[i], speed[i]};
        }
        Arrays.sort(cars, Comparator.comparingInt(o -> o[0])); // sort the array by position
        for (int i = cars.length - 1; i >= 0; i--) {
            double timeToTarget = (double) (target - cars[i][0]) / cars[i][1];
            // if current timeToTarget is less than or equal to the top of the fleetStack timeToTarget
            // it would mean they would collide and therefore is considered part of the fleet
            // if it doesn't, meaning current timeToTarget greater than (takes longer to reach) the top of stack time to target
            // then it would mean it isn't part of the fleet and will be added to the stack on top
            if(!fleetStack.isEmpty() && timeToTarget <= fleetStack.peek())
                continue;
            else
                fleetStack.push(timeToTarget);
        }
        return fleetStack.size();
    }
}