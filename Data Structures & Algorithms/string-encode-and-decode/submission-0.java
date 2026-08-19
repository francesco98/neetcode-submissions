class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;

        while(i < str.length()) {
            StringBuilder l = new StringBuilder();
            while(str.charAt(i) != '#') {
                l.append(str.charAt(i));
                i++;
            }

            i++;
            int j = 0;
            int length = Integer.parseInt(l.toString());
            StringBuilder s = new StringBuilder();
            while(j < length) {
                s.append(str.charAt(i));
                j++;
                i++;
            }

            strs.add(s.toString());
        }

        return strs;
    }
}
