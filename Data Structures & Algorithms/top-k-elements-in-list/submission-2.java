class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            int prev = freq.getOrDefault(num, 0);
            freq.put(num, prev+1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue((a,b) -> freq.get(a) - freq.get(b));

        for(Integer elem : freq.keySet()) {
            queue.offer(elem);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[k];
        for(int j = 0; j < k; j++) {
            result[j] = queue.poll();
        }

        return result;
    }
}
