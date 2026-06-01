class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0, n = cost.length;
        for(int i=n-1;i>=0;i-=3){
            res += cost[i];
            if(i-1 >= 0) res += cost[i-1];
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna