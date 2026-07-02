class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] memo = new int[n][m];
        int res = 0;
        for(int i = 0; i < n; i++){
            memo[i][0] = (matrix[i][0] == '1') ? 1 : 0;
            if(memo[i][0] == 1) res = 1;
        }
        for(int j = 0; j < m; j++){
            memo[0][j] = (matrix[0][j] == '1') ? 1 : 0;
            if(memo[0][j] == 1) res = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == '1'){
                    memo[i][j] = 1 + Math.min(memo[i-1][j], Math.min(memo[i][j-1], memo[i-1][j-1]));
                }
                res = Math.max(res, memo[i][j]);
            }
        }
        return res*res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna