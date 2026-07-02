class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] memo = new int[n+1][m+1];
        memo[n-1][m-1]  = grid[n-1][m-1];
        for(int i = n-2; i >= 0; i--) memo[i][m-1] = grid[i][m-1] + memo[i+1][m-1];
        for(int j = m-2; j >= 0; j--) memo[n-1][j] = grid[n-1][j] + memo[n-1][j+1];
        for(int i = n-2; i >= 0; i--){
            for(int j = m-2 ; j >= 0; j--){
                memo[i][j] = grid[i][j] + Math.min(memo[i+1][j], memo[i][j+1]);
            }
        }
        return memo[0][0];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna