class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(), result);

        return result;
    }

    public void dfs(int n, int nOpen, int nClosed, StringBuilder current, List<String> result) {
        if(nClosed == n) {
            result.add(current.toString());
            return;
        }

        if(nOpen+nClosed < n) {
            current.append("(");
            dfs(n, nOpen+1, nClosed, current, result);
            current.delete(current.length()-1, current.length());
        }

        if(nOpen > 0) {
            current.append(")");
            dfs(n, nOpen-1, nClosed+1, current, result);
            current.delete(current.length()-1, current.length());
        }
        
    }
}
