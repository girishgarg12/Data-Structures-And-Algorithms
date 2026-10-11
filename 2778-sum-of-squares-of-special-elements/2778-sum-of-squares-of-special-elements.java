class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i = 0 ; i < n; i++){
            if(n % (i+1) == 0) res += nums[i]*nums[i];
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna