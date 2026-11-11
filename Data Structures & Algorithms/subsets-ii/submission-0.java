class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int[] input = Arrays.copyOf(nums, nums.length);
        Arrays.sort(input);

        List<List<Integer>> result = new ArrayList<>();
        dfs(input, 0, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if(index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        dfs(nums, index+1, current, result);
        current.remove(current.size()-1);

        int next = index+1;
        while(next < nums.length && nums[next] == nums[index]) {
            next++;
        }

        dfs(nums, next, current, result);
    }
}
