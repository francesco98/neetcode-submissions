class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] input = Arrays.copyOf(candidates, candidates.length);
        Arrays.sort(input);

        List<List<Integer>> result = new ArrayList<>();
        dfs(input, target, 0, 0, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int[] input, int target, int i, int sum, List<Integer> comb, List<List<Integer>> result) {
        if(sum == target) {
            result.add(new ArrayList<>(comb));
            return;
        }

        if(i >= input.length || sum > target) {
            return;
        }

        comb.add(input[i]);
        dfs(input, target, i+1, sum+input[i], comb, result);
        comb.remove(comb.size()-1);

        int next = i+1;
        while(next < input.length && input[next] == input[i]) {
            next++;
        }

        dfs(input, target, next, sum, comb, result);
    }
}
