class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        List<List<Integer>> res = new ArrayList<>();
        int x = 0;
        for(int j = 0; j < k; j++){
            int prev = grid[0][0];
            grid[0][0] = grid[n-1][m-1];
            for(int i = 1; i < n*m; i++){
                int row = i / m;
                int col = i % m;
                int temp = grid[row][col];
                grid[row][col] = prev;
                prev = temp;
            }
        }
        for(int i = 0; i < n; i++){
            res.add(new ArrayList<>());
            for(int j = 0; j < m; j++) res.get(i).add(grid[i][j]);
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna