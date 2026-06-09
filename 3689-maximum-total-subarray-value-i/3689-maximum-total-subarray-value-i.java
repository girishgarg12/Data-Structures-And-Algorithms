class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long res = 0;
        int min = nums[0], max = nums[0];
        for(int x : nums){
            min = Math.min(min,x);
            max = Math.max(max,x);
        }
        res = (long)(max - min) * k;
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna