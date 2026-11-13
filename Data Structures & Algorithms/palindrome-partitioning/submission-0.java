class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), result);

        return result;
    }

    public void dfs(String s, int start, List<String> current, List<List<String>> result) {
        if(start >= s.length()) {
            result.add(new ArrayList(current));
        }
        
        for(int end = start; end < s.length(); end++) {
            String sub = s.substring(start, end+1);
            if(isPalindrome(sub)) {
                current.add(sub);
                dfs(s, end+1, current, result);
                current.remove(current.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        for(int i = 0; i < s.length()/2; i++) {
            int j = s.length()-i-1;
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true; 
    }
}
