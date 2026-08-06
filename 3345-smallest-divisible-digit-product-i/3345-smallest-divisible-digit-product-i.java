class Solution {
    public int smallestNumber(int n, int t) {
        int res = n;
        while(true) {
            int temp = res;
            int p = 1;
            while(temp > 0){
                p *= temp % 10;
                temp /= 10;
            }
            if(p % t == 0) break;
            res++;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna