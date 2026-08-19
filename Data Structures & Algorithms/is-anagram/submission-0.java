class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Integer, Integer> sH = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            int c = (int) s.charAt(i);
            sH.put(c, sH.getOrDefault(c,0)+1);
        }

        for(int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            if(!sH.containsKey(c)) {
                return false;
            }

            int n = sH.get(c)-1;

            if(n == 0) {
                sH.remove(c);
            }
            else {
                sH.put(c, n);
            }
        }

        return sH.isEmpty();
    }
}
