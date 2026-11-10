class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1+costs[0];
        if(n==1)    return dp[1];
        dp[2]=Math.min(dp[1]+1+costs[1],4+costs[1]);
        for(int i=3;i<=n;i++){
            dp[i]=Math.min(1+costs[i-1]+dp[i-1],Math.min(4+costs[i-1]+dp[i-2],9+costs[i-1]+dp[i-3]));
        }
        return dp[n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna