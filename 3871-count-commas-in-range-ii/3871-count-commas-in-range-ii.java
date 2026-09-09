class Solution {
    public long countCommas(long n) {
        if(n < 1000) return 0;
        long s = 1000;
        long res = 0;
        while(s <= n){
            res += n - s + 1;
            s *= 1000;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna