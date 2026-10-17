class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            int prev = freq.getOrDefault(num, 0);
            freq.put(num, prev+1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length+1];

        for(Map.Entry<Integer, Integer> elem : freq.entrySet()) {
            if(buckets[elem.getValue()] == null) {
                buckets[elem.getValue()] = new ArrayList<>();
            }

            buckets[elem.getValue()].add(elem.getKey());
        }

        int[] result = new int[k];
        int j = 0;

        for(int i = buckets.length-1; i >= 0 ; i--) {
            if(buckets[i] != null) {
                for(Integer el : buckets[i]) {
                    result[j++] = el;

                    if(j == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
