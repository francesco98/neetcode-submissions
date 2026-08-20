class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> index = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            while(!index.isEmpty() && temperatures[i] > temperatures[index.peek()]) {
                int k = index.pop();
                result[k] = i - k; 
            }

            index.push(i);
        }

        return result;
    }
}
