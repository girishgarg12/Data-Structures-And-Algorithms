class Solution {
    class triple {
        int row, col, time;
        triple(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int[] row = new int[]{-1,0,1,0};
    public int[] col = new int[]{0,1,0,-1};
    public boolean bfs(int[][] fireTime, int initTime) {
        int n = fireTime.length, m = fireTime[0].length;
        if(initTime > fireTime[0][0]) return false;
        boolean[][] visited = new boolean[n][m];
        Queue<triple> q = new ArrayDeque<>();
        q.add(new triple(0,0,initTime));
        visited[0][0] = true;
        while(!q.isEmpty()){
            triple t = q.remove();
            int r = t.row;
            int c = t.col;
            int time = t.time;
            if(r == n-1 && c == m-1) return true;
            for(int i = 0; i < 4; i++){
                int nRow = r + row[i];
                int nCol = c + col[i];
                int nTime = time + 1;
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol]
                && fireTime[nRow][nCol] != -1){
                    visited[nRow][nCol] = true;
                    if(nRow == n-1 && nCol == m-1){
                       if(nTime <= fireTime[nRow][nCol]) q.add(new triple(nRow, nCol, nTime));
                    }
                    else{
                        if(nTime < fireTime[nRow][nCol]) q.add(new triple(nRow, nCol, nTime));
                    }
                }
            }
        }
        return false;
    }
    public int maximumMinutes(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] fireTime = new int[n][m];
        Queue<triple> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2) fireTime[i][j] = -1;
                else if(grid[i][j] == 0) fireTime[i][j] = Integer.MAX_VALUE;
                else q.add(new triple(i,j,0));
            }
        }
        while(!q.isEmpty()) {
            triple t = q.remove();
            int r = t.row;
            int c = t.col;
            int time = t.time;
            for(int i = 0; i < 4; i++){
                int nRow = r + row[i];
                int nCol = c + col[i];
                int nTime = time + 1;
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && fireTime[nRow][nCol] > nTime && fireTime[nRow][nCol] != -1){
                    fireTime[nRow][nCol] = nTime;
                    q.add(new triple(nRow, nCol, nTime));
                }
            }
        }
        int l = 0, r = n*m + 1;
        while(l <= r){
            int mid = l + (r-l)/2;
            boolean canReach = bfs(fireTime, mid);
            if(canReach) l = mid + 1;
            else r = mid - 1;
        }
        return (r == (n*m)+1) ? 1000000000 : r;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna