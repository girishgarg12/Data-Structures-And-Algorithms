class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1, dec = 1;
        int res1 = 1, res2 = 1;
        int n = nums.length;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i-1]){
                inc++;
                res1 = Math.max(res1, inc);
            }
            else inc = 1;
        }
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i-1]){
                dec++;
                res2 = Math.max(res2, dec);
            }
            else dec = 1;
        }
        return Math.max(res1, res2);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna