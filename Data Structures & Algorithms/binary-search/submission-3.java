class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while(l < r) {
            int c = l+(r-l)/2;

            if(nums[c] == target) {
                return c;
            }

            if(nums[c] < target) {
                l = c+1;
            } 
            else {
                r = c;
            } 
        }

        return -1;
    }
}
