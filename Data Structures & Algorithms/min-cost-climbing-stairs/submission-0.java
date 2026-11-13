class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minPath = new int[cost.length+2];

        for(int i = cost.length-1; i >= 0; i--) {
            minPath[i] = cost[i] + Math.min(minPath[i+1], minPath[i+2]);
        }

        return Math.min(minPath[0], minPath[1]);
    }
}
