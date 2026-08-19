class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            boolean[] colChecks = new boolean[9];
            boolean[] rowChecks = new boolean[9];
            boolean[] boxChecks = new boolean[9];
            
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] != '.') {
                    if(rowChecks[board[i][j] - '1']) {
                        return false;
                    }

                    rowChecks[board[i][j] - '1'] = true;
                }

                if(board[j][i] != '.') {
                    if(colChecks[board[j][i] - '1']) {
                        return false;
                    }

                    colChecks[board[j][i] - '1'] = true;
                }

                int r = (i / 3) * 3 + j / 3;
                int c = (i % 3) * 3 + j % 3;
                if(board[r][c] != '.') {
                    if(boxChecks[board[r][c] - '1']) {
                        return false;
                    }

                    boxChecks[board[r][c] - '1'] = true;
                }


            }
        }

        return true;
    }
}
