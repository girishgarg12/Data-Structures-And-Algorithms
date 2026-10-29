class Solution {
    public void dfs(int[][] grid, int i, int j, int xor, boolean[][][] memo) {
        int n = grid.length;
        int m = grid[0].length;
        if(memo[i][j][xor]) return;
        memo[i][j][xor] = true;
        if(i == n-1 && j == m-1) return;
        if(i+1 < n){
            dfs(grid, i+1, j, grid[i+1][j] ^ xor, memo);
        }
        if(j+1 < m){
            dfs(grid, i, j+1, grid[i][j+1] ^ xor, memo);
        }
    }
    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][][] memo = new boolean[n][m][1024];

        dfs(grid, 0, 0, grid[0][0], memo);

        for(int i = 0; i < 1024; i++){
            if(memo[n-1][m-1][i]) return i;
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna