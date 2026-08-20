class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length;

        while(l < r) {
            int c = l + (r-l)/2;

            int i = c/matrix[0].length;
            int j = c%matrix[0].length;

            if(matrix[i][j] == target) {
                return true;
            }

            if(matrix[i][j] < target) {
                l = c+1;
            } 
            else {
                r = c;
            }
        }

        return false;
    }
}
