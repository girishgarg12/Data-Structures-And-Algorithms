class Solution {
    class pair {
        int first, second;
        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    class triple {
        int row, col, val;
        triple(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length, m = grid[0].length;
        int k = queries.length;
        int[] res = new int[k];
        pair[] sortedQ = new pair[k];
        for(int i = 0; i < k; i++){
            sortedQ[i] = new pair(queries[i], i);
        }
        Arrays.sort(sortedQ, (a,b) -> a.first - b.first);
        int[] row = new int[]{-1,0,1,0};
        int[] col = new int[]{0,1,0,-1};
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<triple> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        int idx = 0, r = 0;
        pq.add(new triple(0,0,grid[0][0]));
        visited[0][0] = true;
        while(idx < k && !pq.isEmpty()) {
            int currVal = sortedQ[idx].first;
            int i = sortedQ[idx].second;
            while(currVal > pq.peek().val){
                r++;
                triple t = pq.remove();
                int ro = t.row;
                int co = t.col;
                int val = t.val;
                for(int j = 0; j < 4; j++){
                    int nRow = ro + row[j];
                    int nCol = co + col[j];

                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol]){
                        visited[nRow][nCol] = true;
                        pq.add(new triple(nRow, nCol, grid[nRow][nCol]));
                    }
                }
                if(pq.isEmpty()) break;
            }
            res[i] = r;
            idx++;
        }
        if(idx < k){
            for(int i = idx; i < k; i++){
                res[sortedQ[i].second] = r;
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna