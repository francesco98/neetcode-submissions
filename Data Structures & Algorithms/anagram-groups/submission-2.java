class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<Map<Character, Integer>, List<String>> groups = new HashMap<>();

        for(String str : strs) {
            Map<Character, Integer> key = toKey(str);
            if(!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }

            groups.get(key).add(str);
        } 

        return groups.values().stream().toList();
    }

    private Map<Character, Integer> toKey(String str) {
        final Map<Character, Integer> keyGroup = new HashMap<>();

        for(char c : str.toCharArray()) {
            int prev = keyGroup.getOrDefault(c, 0);
            keyGroup.put(c, prev+1);
        }

        return keyGroup;
    }
}
