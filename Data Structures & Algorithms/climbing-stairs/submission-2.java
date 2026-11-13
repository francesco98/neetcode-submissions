class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+2];
        memo[n] = 1;

        for(int i = n-1; i >= 0; i--) {
            memo[i] = memo[i+1]+memo[i+2];
        }

        return memo[0];
    }
}
