class Solution {
    int mod = 1000000007;
    public int paths(int[][] grid, int i , int j, int fromUp, int[][][] memo) {
        if(i >= grid.length || j >= grid[0].length) return 0;
        if(i == grid.length -1 && j == grid[0].length - 1) return 1;
        if(memo[i][j][fromUp] != -1) return memo[i][j][fromUp];
        if(grid[i][j] == 1 && fromUp == 1){
            memo[i][j][fromUp] = paths(grid, i, j+1, 0, memo);
        }
        else if(grid[i][j] == 1 && fromUp == 0){
            memo[i][j][fromUp] = paths(grid, i+1, j, 1, memo);
        }
        else{
            memo[i][j][fromUp] = (paths(grid, i+1, j, 1, memo) + paths(grid, i, j+1, 0, memo)) % mod;
        }
        return memo[i][j][fromUp];
    }
    public int uniquePaths(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][] memo = new int[n][m][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) Arrays.fill(memo[i][j], -1);
        }
        return paths(grid, 0, 0, 0, memo);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna