class Solution {
    public int numIslands(char[][] grid) {

        int nIslands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    nIslands++;
                    bfs(grid, i, j);
                }
            }
        }

        return nIslands;
    }

    private void bfs(char[][] grid, int i, int j) {
        final Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                char v = grid[x][y];
                if(v == '1') {
                    grid[x][y] = 'x';
                    if(x > 0) queue.offer(new int[]{x-1, y});
                    if(x < grid.length-1) queue.offer(new int[]{x+1, y});
                    if(y > 0) queue.offer(new int[]{x, y-1});
                    if(y < grid[0].length-1) queue.offer(new int[]{x, y+1});
                }
            }
        }
    }
}
