class Solution {
    public int dp(int[] stoneValue, int i, Integer[] memo){
        if(i == stoneValue.length) return 0;
        if(memo[i] != null) return memo[i];
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for(int idx = i; idx < Math.min(i + 3, stoneValue.length); idx++){
            sum += stoneValue[idx];
            res = Math.max(res, sum - dp(stoneValue, idx+1, memo));
        }
        return memo[i] = res;
    }
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] memo = new Integer[n];
        int diff = dp(stoneValue, 0, memo);
        if(diff > 0) return "Alice";
        else if(diff < 0) return "Bob";
        else return "Tie";
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna