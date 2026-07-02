class Solution {
    class truple {
        int time, row, col;
        truple(int time, int row, int col){
            this.time = time;
            this.col = col;
            this.row = row;
        }
    }
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        PriorityQueue<truple> q = new PriorityQueue<>((a,b) -> a.time - b.time);
        int[][] time = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(time[i], Integer.MAX_VALUE);
        int[] r = new int[]{-1,0,1,0};
        int[] c = new int[]{0,1,0,-1};
        q.add(new truple(0,0,0));
        time[0][0] = 0;
        while(!q.isEmpty()){
            truple t = q.remove();
            int currTime = t.time;
            int row = t.row;
            int col = t.col;
            if(row == n-1 && col == m-1) return currTime;
            for(int i = 0; i < 4; i++){
                int nRow = row + r[i];
                int nCol = col + c[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                    int nTime = (moveTime[nRow][nCol] < currTime) ? currTime + 1 : currTime + (moveTime[nRow][nCol] - currTime) + 1;
                    if(time[nRow][nCol] > nTime){
                        time[nRow][nCol] = nTime;
                        q.add(new truple(nTime, nRow, nCol));
                    }
                }
            }
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna