class Solution {
    class truple {
        int obstacles, dist, row, col;
        truple(int obstacles, int dist, int row, int col){
            this.obstacles = obstacles;
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<truple> pq = new PriorityQueue<>((a,b) -> b.obstacles - a.obstacles);
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        int[] r = new int[]{-1,0,1,0};
        int[] c = new int[]{0,1,0,-1};
        pq.add(new truple(k, 0, 0, 0));
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            truple t = pq.remove();
            int currObst = t.obstacles;
            int currDist = t.dist;
            int row = t.row;
            int col = t.col; 
            for(int i = 0; i < 4; i++){
                int nRow = row + r[i];
                int nCol = col + c[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && dist[nRow][nCol] > currDist + 1 && currObst - grid[nRow][nCol] >= 0){
                    dist[nRow][nCol] = currDist + 1;
                    pq.add(new truple(currObst - grid[nRow][nCol], currDist + 1, nRow, nCol));
                }
            }
        }
        return (dist[n-1][m-1] == Integer.MAX_VALUE) ? -1 : dist[n-1][m-1];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna