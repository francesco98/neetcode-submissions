class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> setNums = new HashSet<>();
        for(int num : nums) {
            setNums.add(num);
        }

        int max = 0;

        for(int num : setNums) {
            if(setNums.contains(num-1)) {
                continue;
            }

            int l = 1;
            while(setNums.contains(num+l)) {
                l++;
            }

            if(l > max) {
                max = l;
            }
        }

        return max;
    }
}
