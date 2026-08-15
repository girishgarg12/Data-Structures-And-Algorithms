class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0, z = 0;
        for(int x : nums){
            xor ^= x;
            if(x == 0) z++;
        }
        if(z == n) return 0;
        if(xor == 0) return n - 1;
        return n;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna