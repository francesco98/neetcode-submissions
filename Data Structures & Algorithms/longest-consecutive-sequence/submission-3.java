class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> setNums = new HashSet<>();
        for(int num : nums) {
            setNums.add(num);
        }

        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            if(setNums.contains(nums[i]-1)) {
                continue;
            }

            int l = 1;
            while(setNums.contains(nums[i]+l)) {
                l++;
            }

            if(l > max) {
                max = l;
            }
        }

        return max;
    }
}
