class Solution {
    public int countCommas(int n) {
        int res = 0;
        if(n > 999) res += (n > 9999) ? 9999-999 : n - 999;
        if(n > 9999) res += (n > 99999) ? 99999-9999 : n - 9999;
        if(n > 99999) res += n - 99999;
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna