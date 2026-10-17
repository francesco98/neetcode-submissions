class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> groups = new HashMap<>();

        for(String str : strs) {
            final String key = toKey(str);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        } 

        return groups.values().stream().toList();
    }

    private String toKey(String str) {
        final int[] keyGroup = new int[26];

        for(char c : str.toCharArray()) {
            keyGroup[c - 'a']++;
        }

        return Arrays.toString(keyGroup);
    }
}
