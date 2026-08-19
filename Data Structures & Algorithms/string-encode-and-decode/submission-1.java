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

        while (i < str.length()) {
            int sep = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, sep));
            strs.add(str.substring(sep + 1, sep + 1 + length));
            i = sep + 1 + length;
        }

        return strs;
    }
}
