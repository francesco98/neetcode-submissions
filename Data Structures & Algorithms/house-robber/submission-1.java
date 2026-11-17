class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+2];

        for(int i = dp.length-3; i>=0; i--) {
            dp[i] = Math.max(dp[i+1], nums[i] + dp[i+2]);
        }

        return dp[0];
    }
}
