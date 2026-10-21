class TimeMap {
    private final Map<String, List<String>> valuesMap = new HashMap<>();
    private final Map<String, List<Integer>> timestampsMap = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        valuesMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        timestampsMap.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        if(!valuesMap.containsKey(key)) {
            return "";
        }

        final List<String> values = valuesMap.get(key);
        final List<Integer> timestamps = timestampsMap.get(key);

        int l = 0;
        int r = values.size();
        
        while(l < r) {
            int c = l + (r-l)/2;

            if(timestamps.get(c) == timestamp) {
                return values.get(c);
            }

            if(timestamp < timestamps.get(c)) {
                r = c;
            }
            else {
                l = c + 1;
            }
        }

        if(l == 0) {
            return "";
        }
        else {
            return values.get(l-1);
        }
    }
}
