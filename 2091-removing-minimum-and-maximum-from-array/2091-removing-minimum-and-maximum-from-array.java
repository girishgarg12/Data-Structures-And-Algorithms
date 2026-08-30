class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minI = -1, maxI = -1;
        for(int i = 0; i < n; i++){
            if(nums[i] < min){
                min = nums[i];
                minI = i;
            }
            if(nums[i] > max){
                max = nums[i];
                maxI = i;
            }
        }
        int l = Math.min(minI, maxI);
        int r = Math.max(minI, maxI);
        return Math.min((n - l), Math.min(r + 1, l + 1 + (n - r)));
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna