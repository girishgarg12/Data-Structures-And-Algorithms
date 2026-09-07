class Solution {
    public int mod = 1000000007;
    public int distinctSubseqII(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx, -1);
        for(int i = 1 ; i <= n; i++){
            char c = s.charAt(i-1);
            if(lastIdx[c - 'a'] == -1){
                dp[i] = (dp[i-1] * 2 + 1) % mod; 
            }
            else{
                dp[i] = (dp[i-1] * 2 - (dp[lastIdx[c - 'a'] - 1]) + mod) % mod;
            }
            lastIdx[c - 'a'] = i;
        }
        return (int)dp[n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna