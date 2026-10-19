class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final Deque<Integer> indexStack = new ArrayDeque<>();
        final int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            while(!indexStack.isEmpty() && temperatures[i] > temperatures[indexStack.peek()]) {
                int j = indexStack.pop();
                result[j] = i - j;
            }

            indexStack.push(i);
        }

        while(!indexStack.isEmpty()) {
            result[indexStack.pop()] = 0;
        }

        return result;
    }
}
