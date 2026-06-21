class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = costs[0];
        int n = costs.length;
        for(int x : costs) max = Math.max(x,max);
        int[] cntArr = new int[max+1];
        for(int i=0;i<n;i++){
            cntArr[costs[i]]++;
        }
        for(int i=1;i<=max;i++){
            cntArr[i] += cntArr[i-1];
        }
        int[] sorted = new int[n];
        for(int i=n-1;i>=0;i--){
            sorted[cntArr[costs[i]] - 1] = costs[i];
            cntArr[costs[i]]--;
        }
        int res = 0;
        for(int i=0;i<n;i++){
            coins -= sorted[i];
            if(coins >= 0) res++;
            else break;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna