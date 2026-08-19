class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for(String str : strs) {
            String key = computeKey(str);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(str);
        }

        return groups.values().stream().toList();
    }

    public String computeKey(String str) {
        int[] key = new int[26];
        for(int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            key[c-'a']++;
        }

        return Arrays.toString(key);
    }
}
