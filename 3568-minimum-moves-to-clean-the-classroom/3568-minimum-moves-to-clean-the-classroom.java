class Solution {
    class pair {
        int row, col, dis, en, m;
        pair(int row, int col, int dis, int en, int m) {
            this.row = row;
            this.col = col;
            this.dis = dis;
            this.en = en;
            this.m = m;
        }
    }
    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length, m = classroom[0].length();
        char[][] arr = new char[n][m];
        int[][] litterId = new int[n][m];
        int litter = 0;
        int sr = -1, sc = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = classroom[i].charAt(j);
                if(arr[i][j] == 'L') litterId[i][j] = litter++;
                if(arr[i][j] == 'S'){
                    sr = i;
                    sc = j;
                }
            }
        }
        int mask = 1 << litter;
        int[][][] best = new int[n][m][mask];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                Arrays.fill(best[i][j], -1);
            }
        }
        int[] r = new int[]{-1, 0, 1, 0};
        int[] c = new int[]{0,1,0, -1};
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(sr, sc, 0, energy, 0));
        best[sr][sc][0] = energy;
        int finalMask = mask - 1;
        while(!q.isEmpty()) {
            pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int dis = p.dis;
            int en = p.en;
            int ma = p.m;
            if(ma == finalMask) return dis;
            if(en == 0) continue;
            for(int i = 0; i < 4; i++){
                int nRow = row + r[i];
                int nCol = col + c[i];
                    
                if(nRow < 0 || nRow > n - 1 || nCol < 0 || nCol > m - 1) continue;
                    
                if(arr[nRow][nCol] == 'X') continue;
                        
                int newEn = en - 1;
                if(arr[nRow][nCol] == 'R') newEn = energy;

                int newMask = ma;
                if(arr[nRow][nCol] == 'L'){
                    int id = litterId[nRow][nCol];
                    newMask |= (1 << id);
                }
                if(newEn > best[nRow][nCol][newMask]){
                    best[nRow][nCol][newMask] = newEn;
                    q.add(new pair(nRow, nCol, dis+1, newEn, newMask));
                }
                
            }
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna