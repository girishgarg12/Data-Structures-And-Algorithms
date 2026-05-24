class Solution {
    public int solve(int[] arr, int idx, int d,int[] dp){
        int c=1;
        if(dp[idx] != -1) return dp[idx];
        for(int i=idx+1;i<=idx+d && i<arr.length;i++){
            if(arr[i]>=arr[idx]) break;
            c = Math.max(c,1+solve(arr,i,d,dp));
        }
        for(int i=idx-1;i>=idx-d && i>=0;i--){
            if(arr[i]>=arr[idx]) break;
            c = Math.max(c,1+solve(arr,i,d,dp));
        }
        return dp[idx] = c;
    }
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int res = 0;
        for(int i=0;i<n;i++){
            res = Math.max(res,solve(arr,i,d,dp));
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna