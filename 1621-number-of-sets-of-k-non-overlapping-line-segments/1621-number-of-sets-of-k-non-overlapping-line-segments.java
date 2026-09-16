class Solution {
    public int mod = 1000000007;
    public int solve(int n, int i, int k, int [][] memo){
        if(k == 0){
            return 1;
        }
        if(i == n) return 0;
        if(memo[i][k] != -1) return memo[i][k];
        
        int res = solve(n, i+1, k, memo);
        for(int j = i+1; j < n; j++){
            res = (res + solve(n, j, k-1, memo)) % mod;
        }
        return memo[i][k] = res;
    }
    public int numberOfSets(int n, int k) {
        if(k == n-1) return 1;
        int[][] memo = new int[n+1][k+1];
        for(int i = 0; i <= n; i++) Arrays.fill(memo[i], -1);
        return solve(n, 0, k, memo);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna