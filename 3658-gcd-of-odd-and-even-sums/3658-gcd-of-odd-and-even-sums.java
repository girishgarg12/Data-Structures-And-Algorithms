class Solution {
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, Math.abs(a-b));
    }
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0, sumEven = 0;
        int o = 1, e = 2;
        for(int i = 0; i < n; i++){
            sumOdd += o;
            sumEven += e;
            o += 2;
            e += 2;
        }
        return gcd(sumOdd, sumEven);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna