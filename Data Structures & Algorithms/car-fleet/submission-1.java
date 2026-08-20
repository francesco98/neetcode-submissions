class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        final Integer[] order = new Integer[position.length];
        
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (i, j) -> position[j] - position[i]);

        int nFleets = 0;
        double leaderTime = -1;

        for(int i = 0; i < order.length; i++) {
            double t = (target - position[order[i]]) / Double.valueOf(speed[order[i]]);

            if(t > leaderTime) {
                nFleets++;
                leaderTime = t;
            }
        }

        return nFleets;
    }
}
