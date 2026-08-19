class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();

        for(int n : nums) {
            if(uniqueNums.contains(n)) {
                return true;
            }

            uniqueNums.add(n);
        }

        return false;
    }
}