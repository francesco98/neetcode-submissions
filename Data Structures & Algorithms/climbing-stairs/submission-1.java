class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+3];
        dfs(n, 0, memo);

        return memo[0];
    }

    private int dfs(int n, int pos, int[] memo) {
        if(pos == n) {
            return 1;
        }

        if(pos > n) {
            return 0;
        }

        int rPos1 = memo[pos+1] > 0 ? memo[pos+1] : dfs(n, pos+1, memo);
        int rPos2 = memo[pos+2] > 0 ? memo[pos+2] : dfs(n, pos+2, memo);
        memo[pos] = rPos1+rPos2;

        return memo[pos];
    }
}
