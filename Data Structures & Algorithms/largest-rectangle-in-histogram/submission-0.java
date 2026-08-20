class Solution {
    public int largestRectangleArea(int[] heights) {
        final Deque<Integer> idx = new ArrayDeque<>();
        int max = 0;

        for(int i = 0; i < heights.length; i++) {
            while(!idx.isEmpty() && heights[i] < heights[idx.peek()]) {
                int j = idx.pop();
                int left = idx.isEmpty() ? -1 : idx.peek();

                int a = heights[j] * (i - left - 1);
                if(a > max) {
                    max = a;
                }
            }

            idx.push(i);
        }

        while(!idx.isEmpty()) {
            int j = idx.pop();
            int left = idx.isEmpty() ? -1 : idx.peek();

            int a = heights[j] * (heights.length - left - 1);
            if(a > max) {
                max = a;
            }
        }

        return max;
    }
}
