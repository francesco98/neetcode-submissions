class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, target, new ArrayList<>(), 0, result);
        return result;
    }

    private void dfs(int index, int[] nums, int target, List<Integer> current, int sum, List<List<Integer>> result) {
        if(sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if(sum > target || index == nums.length) {
            return;
        }

        current.add(nums[index]);
        sum += nums[index];
        dfs(index, nums, target, current, sum, result);

        current.remove(current.size()-1);
        sum -= nums[index];
        dfs(index+1, nums, target, current, sum, result);
    }
}
