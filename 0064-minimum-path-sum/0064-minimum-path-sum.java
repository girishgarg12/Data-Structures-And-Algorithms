class Solution {
    public int helper(int[][] grid, int i, int j, int[][] memo){
        if(i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if(i == grid.length-1 && j == grid[0].length-1) return grid[i][j];
        if(memo[i][j] != -1) return memo[i][j];
        memo[i][j] = grid[i][j] + Math.min(helper(grid, i+1, j, memo), helper(grid, i, j+1, memo));
        return memo[i][j];
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] memo = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(memo[i], -1);
        return helper(grid, 0, 0, memo);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna