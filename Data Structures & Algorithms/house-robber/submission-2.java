class Solution {
    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;

        for(int i = nums.length-1; i >= 0; i--) {
            a = Math.max(b, nums[i]+c);
            int tmp = b;
            b = a;
            c = tmp;
        }

        return a; 
    }
}
