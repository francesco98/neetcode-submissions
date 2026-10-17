class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mapNums = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            mapNums.put(nums[i], i);
        }
        
        int max = 0;
        boolean[] visited = new boolean[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            }

            int l = 1;

            while(mapNums.containsKey(nums[i]+l)) {
                visited[mapNums.get(nums[i]+l)] = true;
                l++;
            }

            if(l > max) {
                max = l;
            }
        }

        return max;
    }
}
