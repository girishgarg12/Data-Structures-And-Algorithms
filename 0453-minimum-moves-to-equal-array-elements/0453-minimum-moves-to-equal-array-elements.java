class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0], n = nums.length;
        for(int x : nums) min = Math.min(x, min);
        int res = 0;
        for(int i = 0; i < n; i++) res += nums[i] - min;
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna