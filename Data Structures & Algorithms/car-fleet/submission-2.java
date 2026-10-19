class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer[] order = new Integer[position.length];
        
        for(int i = 0; i < order.length; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (i, j) -> position[j] - position[i]);

        int nFleet = 0;
        double maxTime = 0;

        for(int i = 0; i < order.length; i++) {
            double time = (target - position[order[i]]) / Double.valueOf(speed[order[i]]);

            if(time > maxTime) {
                nFleet++;
                maxTime = time;
            }
        }

        return nFleet;
        
    }
}
