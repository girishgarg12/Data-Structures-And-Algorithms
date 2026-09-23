class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int s = 0;
        for(int y : nums) s += y;
        s -= x;
        int l = 0;
        int maxLen = -1;
        int sum = 0;
        for(int r = 0; r < n; r++){
            sum += nums[r];
            while(sum > s && l <= r){
                sum -= nums[l];
                l++;
            }
            if(sum == s){
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }
        if(maxLen == -1) return -1;
        return n - maxLen;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna