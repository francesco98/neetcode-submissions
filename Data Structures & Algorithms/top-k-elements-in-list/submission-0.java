class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        

        for(int num: nums) {
            int count = counts.getOrDefault(num, 0)+1;
            counts.put(num, count);
        }

        List<Integer>[] buckets = new ArrayList[nums.length+1];

        for(Map.Entry<Integer,Integer> count : counts.entrySet()) {
            if(buckets[count.getValue()] == null) {
                buckets[count.getValue()] = new ArrayList<>();
            }

            buckets[count.getValue()].add(count.getKey());
        }

        int[] kElements = new int[k];
        int j = 0;

        for(int i = buckets.length-1; i >= 0; i--) {
            if(buckets[i] != null) {
                for(int el : buckets[i]) {
                    kElements[j++] = el;

                    if(j == k) {
                        return kElements;
                    }
                }
            }
        }

        return kElements;
    }
}
