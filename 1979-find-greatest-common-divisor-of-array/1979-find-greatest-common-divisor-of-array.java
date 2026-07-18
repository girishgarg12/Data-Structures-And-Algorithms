class Solution {
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, Math.abs(a-b));
    }
    public int findGCD(int[] nums) {
        int min = nums[0], max = nums[0];
        for(int x : nums){
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return gcd(min, max);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna