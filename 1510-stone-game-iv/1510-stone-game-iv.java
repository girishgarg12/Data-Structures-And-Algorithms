class Solution {
    public boolean helper(int alice, int n, Boolean[][] dp){
        if(n == 0) return (alice == 0);
        if(dp[n][alice] != null) return dp[n][alice];
        boolean res = (alice == 1) ? false : true;
        for(int i = 1; i * i <= n; i++){
            if(alice == 1){
                res = res || helper(0, n - i*i, dp);
            }
            else{
                res = res && helper(1, n - i*i, dp);
            }
        }
        return dp[n][alice] = res;
    }
    public boolean winnerSquareGame(int n) {
        Boolean[][] dp = new Boolean[n+1][2];
        return helper(1, n, dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna