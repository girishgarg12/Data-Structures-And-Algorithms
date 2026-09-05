class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] preMax = new int[n];
        int[] suffMin = new int[n];
        preMax[0] = nums[0]; suffMin[n-1] = nums[n-1];
        for(int i = 1; i < n; i++){
            preMax[i] = Math.max(nums[i], preMax[i-1]);
            suffMin[n - i -1] = Math.min(nums[n - i - 1], suffMin[n - i]);
        }
        for(int i = 0; i < n; i++){
            if(preMax[i] - suffMin[i] <= k) return i;
        }
        return -1;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna