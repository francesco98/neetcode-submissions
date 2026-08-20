class Solution {
    public int trap(int[] height) {
        if(height.length < 3) {
            return 0;
        }

        int water = 0;    
        int[] maxR = new int[height.length];

        for(int i = height.length-2; i >= 1; i--) {
            maxR[i] = Math.max(maxR[i+1], height[i+1]);
        }

        int maxL = 0;

        for(int i = 1; i < height.length-1; i++) {
            maxL = Math.max(maxL, height[i-1]);
            water += Math.max(0, Math.min(maxL, maxR[i]) - height[i]);
        }

        return water;
    }
}
