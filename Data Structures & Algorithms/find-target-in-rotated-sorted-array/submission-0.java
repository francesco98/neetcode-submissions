class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while(l < r) {
            int c = l + (r-l)/2;

            if(nums[c] == target) {
                return c;
            }

            if(nums[l] < nums[c]) {
                if(target >= nums[l] && target < nums[c]) {
                    r = c;
                }
                else {
                    l = c+1;
                }
            }
            else {
                if(target > nums[c] && target <= nums[r-1]) {
                    l = c+1;
                }
                else {
                    r = c;
                }
            }   
        }

        return -1;
    }
}
