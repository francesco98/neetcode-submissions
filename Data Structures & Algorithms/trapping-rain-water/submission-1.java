class Solution {
    public int trap(int[] height) {
        if(height.length < 3) {
            return 0;
        }

        int water = 0;

        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];

        for(int i = 1; i < height.length-1; i++) {
            maxL[i] = Math.max(maxL[i-1], height[i-1]);
        } 

        for(int i = height.length-2; i >= 1; i--) {
            maxR[i] = Math.max(maxR[i+1], height[i+1]);
        }

        for(int i = 1; i < height.length-1; i++) {
            water += Math.max(0, Math.min(maxL[i], maxR[i]) - height[i]);
        }

        return water;
    }
}
