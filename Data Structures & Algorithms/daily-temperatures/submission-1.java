class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final Deque<Integer> indexQueue = new ArrayDeque<>();
        final int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            while(!indexQueue.isEmpty() && temperatures[i] > temperatures[indexQueue.peek()]) {
                int j = indexQueue.poll();
                result[j] = i - j;
            }

            indexQueue.push(i);
        }

        while(!indexQueue.isEmpty()) {
            result[indexQueue.poll()] = 0;
        }

        return result;
    }
}
