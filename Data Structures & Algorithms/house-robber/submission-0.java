class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+3];

        for(int i = dp.length-4; i >= 0; i--) {
            dp[i] = nums[i] + Math.max(dp[i+2], dp[i+3]);
        }

        return Math.max(dp[0], dp[1]);
    }
}
