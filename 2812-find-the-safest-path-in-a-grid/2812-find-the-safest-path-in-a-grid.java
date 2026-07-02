class Solution {
    class truple {
        int dis, row, col;
        truple(int dis, int row, int col){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
    class pair {
        int row, col;
        pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int[] r = new int[]{-1,0,1,0};
    public int[] c = new int[]{0,1,0,-1};

    public boolean hasPath(int[][] dist, int v){
        if(dist[0][0] < v) return false;
        int n = dist.length, m = dist[0].length;
        Queue<pair> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new pair(0, 0));
        visited[0][0] = true;
        while(!q.isEmpty()){
            pair p = q.remove();
            int row = p.row;
            int col = p.col;
            if(row == n-1 && col == m-1) return true; 
            for(int i = 0; i < 4; i++){
                int nRow = row + r[i];
                int nCol = col + c[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol] && dist[nRow][nCol] >= v){
                    visited[nRow][nCol] = true;
                    q.add(new pair(nRow, nCol));
                }
            }
        }
        return false;
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size(), m = grid.get(0).size();
        Queue<truple> q = new ArrayDeque<>();
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) if(grid.get(i).get(j) == 1){
                q.add(new truple(0, i, j));
                dist[i][j] = 0;
                }   
        }
        int max = 0;
        while(!q.isEmpty()){
            truple t = q.remove();
            int d = t.dis;
            int row = t.row;
            int col = t.col;
            for(int i = 0; i < 4; i++){
                int nRow = row + r[i];
                int nCol = col + c[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && dist[nRow][nCol] > d+1){
                    dist[nRow][nCol] = d + 1;
                    max = Math.max(dist[nRow][nCol], max);
                    q.add(new truple(d+1, nRow, nCol));
                }
            }
        }
        int l = 0, r = max;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(hasPath(dist, mid)) l = mid+1;
            else r = mid-1;
        }
        return r;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna