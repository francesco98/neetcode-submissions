class Solution {
    public int trap(int[] height) {
        Deque<Integer> idx = new ArrayDeque<>();

        int water = 0;

        for(int i = 0; i < height.length; i++) {
            while(!idx.isEmpty() && height[i] > height[idx.peek()]) {
                int b = idx.pop();
                
                if(idx.isEmpty()) {
                    break;
                }

                int left = idx.peek();
                int width = i - left - 1;
                water += (Math.min(height[left], height[i]) - height[b]) * width;
            }

            idx.push(i);
        }

        return water;
    }
}
