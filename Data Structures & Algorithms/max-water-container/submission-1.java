class Solution {
    public int maxArea(int[] heights) {
        if(heights.length < 2) {
            return 0;
        }

        int i = 0;
        int j = heights.length-1;

        int max = 0;

        while(i < j) {
            int area = (j-i) * Math.min(heights[i], heights[j]);

            if(area > max) {
                max = area;
            }

            if(heights[i] < heights[j]) {
                i++;
            }
            else {
                j--;
            }

        }

        return max;
    }
}
