class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                boolean[][] used = new boolean[board.length][board[i].length];
                if(existDfs(board, i, j, word, 0, used)) {
                    return true;
                }
            } 
        }

        return false;
    }

    private boolean existDfs(char[][] board, int i, int j, String word, int k, boolean[][] used) {
        if(k >= word.length()) {
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        if(used[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }

        used[i][j] = true;
        boolean result = existDfs(board, i-1, j, word, k+1, used);
        used[i][j] = false;

        used[i][j] = true;
        result |= existDfs(board, i+1, j, word, k+1, used); 
        used[i][j] = false;

        used[i][j] = true;
        result |= existDfs(board, i, j-1, word, k+1, used);
        used[i][j] = false;

        used[i][j] = true;
        result |= existDfs(board, i, j+1, word, k+1, used);
        used[i][j] = false;

        return result;
    }
}
