class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int[] input = Arrays.copyOf(nums, nums.length);
        Arrays.sort(input);

        List<List<Integer>> result = new ArrayList<>();
        dfs(input, 0, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            dfs(nums, i+1, current, result);
            current.remove(current.size()-1);
        }
    
    }

    
}
