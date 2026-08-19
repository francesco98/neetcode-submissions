class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> reverseNums = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int r = target - nums[i];
            
            if(reverseNums.containsKey(r)) {
                return new int[]{reverseNums.get(r), i};
            }

            reverseNums.put(nums[i], i);
        }
        
        return new int[]{-1,-1};
    }
}
