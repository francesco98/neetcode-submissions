class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Integer, Integer>, List<String>> result = new HashMap<>();

        for(String str : strs) {
            Map<Integer, Integer> count = getCounts(str);

            if(!result.containsKey(count)) {
                result.put(count, new ArrayList<>());
            }

            result.get(count).add(str);
        }

        return result.values().stream().toList();
    }

    public Map<Integer, Integer> getCounts(String str) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            count.put(c, count.getOrDefault(c, 0)+1);
        }

        return count;
    }
}
