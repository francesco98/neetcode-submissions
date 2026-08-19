class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> elements = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = 0;

        for(int start : elements) {
            if (elements.contains(start - 1)) 
                continue;

            int curr = start;
            int count = 1;
            while(elements.contains(curr+1)) {
                count++;
                curr++;
            }

            if(count > max) {
                max = count;
            }
        }

        return max;
    }
}
