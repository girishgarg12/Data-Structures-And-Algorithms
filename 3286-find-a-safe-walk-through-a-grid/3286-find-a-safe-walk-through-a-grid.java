class Solution {
    class truple {
        int health, row, col;
        truple(int health, int row, int col){
            this.row = row;
            this.col = col;
            this.health = health;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size(), m = grid.get(0).size();
        PriorityQueue<truple> pq = new PriorityQueue<>((a,b) -> b.health - a.health);
        boolean[][] visited = new boolean[n][m];
        pq.add(new truple(health - grid.get(0).get(0), 0, 0));
        int[] r = new int[]{-1,0,1,0};
        int[] c = new int[]{0,1,0,-1};
        while(!pq.isEmpty()){
            truple t = pq.remove();
            int hel = t.health;
            int row = t.row;
            int col = t.col;
            if(row == n-1 && col == m-1 && hel >= 1) return true;
            for(int i = 0; i < 4; i++){
                int nRow = row + r[i];
                int nCol = col + c[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol]){
                    visited[nRow][nCol] = true;
                    pq.add(new truple(hel - grid.get(nRow).get(nCol), nRow, nCol));
                }
            }
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna