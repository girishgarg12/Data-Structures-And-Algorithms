class Solution {
    class truple {
        int dis, row, col;
        truple(int dis, int row, int col){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
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
        int[] r = new int[]{-1,0,1,0};
        int[] c = new int[]{0,1,0,-1};
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
                    q.add(new truple(d+1, nRow, nCol));
                }
            }
        }
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<truple> pq = new PriorityQueue<>((a,b) -> b.dis - a.dis);
        pq.add(new truple(dist[0][0],0,0));

        while(!pq.isEmpty()){
            truple t = pq.remove();
            int currSafe = t.dis;
            int row = t.row;
            int col = t.col;
            if(row == n-1 && col == m-1) return currSafe;
            for(int i = 0; i < 4; i++){
                int nRow = row + r[i];
                int nCol = col + c[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol]){
                    visited[nRow][nCol] = true;
                    int newSafe = Math.min(currSafe, dist[nRow][nCol]);
                    pq.add(new truple(newSafe, nRow, nCol));
                }
            }
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna