class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length-1; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int l = i+1;
            int r = nums.length-1;
            int sum = nums[i] + nums[l] + nums[r];

            while(l < r) {
                if(sum == 0) {
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                }
                else if(sum > 0) {
                    r--;
                }
                else if(sum < 0) {
                    l++;
                }

                sum = nums[i] + nums[l] + nums[r];
            }
        }
        
        return result;
    }
}
