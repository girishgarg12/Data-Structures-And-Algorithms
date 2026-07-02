class Solution {
    public int helper(char[][] matrix, int i, int j, int[][] memo){
        if(i < 0 || j < 0) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(matrix[i][j] == '1'){
            memo[i][j] = 1 + Math.min(helper(matrix, i-1, j, memo), Math.min(helper(matrix, i, j-1, memo), helper(matrix, i-1, j-1, memo)));
        }
        else{
            memo[i][j] = 0;
        }
        return memo[i][j];
    }
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] memo = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(memo[i], -1);
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                res = Math.max(res, helper(matrix, i , j, memo));
            }
        }
        return res*res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna