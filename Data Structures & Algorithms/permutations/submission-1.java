class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new HashSet<>(), new ArrayList<>(), result);

        return result;
    }

    public void dfs(int[] nums, Set<Integer> existSet, List<Integer> current, List<List<Integer>> result) {
        if(existSet.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!existSet.contains(i)) {
                existSet.add(i);
                current.add(nums[i]);
                dfs(nums, existSet, current, result);
                existSet.remove(i);
                current.remove(current.size()-1);
            }
        }
    }
}
