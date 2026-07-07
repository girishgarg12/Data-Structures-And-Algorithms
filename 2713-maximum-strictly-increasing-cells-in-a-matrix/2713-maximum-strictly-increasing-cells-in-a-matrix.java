class Solution {
    class truple {
        int val, row, col;
        truple(int val, int row, int col){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public int maxIncreasingCells(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        List<truple> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                list.add(new truple(mat[i][j], i, j));
            }
        }
        Collections.sort(list, (a,b) -> a.val - b.val);
        int[] rowBest = new int[n];
        int[] colBest = new int[m];
        int res = 0, k = 0;
        while(k < list.size()){
            int value = list.get(k).val;
            List<int[]> dp = new ArrayList<>();
            while(k < list.size() && list.get(k).val == value){
                truple t = list.get(k);
                int curr = 1 + Math.max(rowBest[t.row], colBest[t.col]);
                res = Math.max(res, curr);
                dp.add(new int[]{curr, t.row, t.col});
                k++;
            }
            
            for(int[] arr: dp){
                int curr = arr[0];
                int row = arr[1];
                int col = arr[2];
                rowBest[row] = Math.max(rowBest[row], curr);
                colBest[col] = Math.max(colBest[col], curr);
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna