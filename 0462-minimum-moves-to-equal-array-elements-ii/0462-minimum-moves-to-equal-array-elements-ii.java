class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 1) return 0;
        int mid = nums[n/2], mid2 = nums[(n/2) - 1];
        int res1 = 0, res2 = 0;
        for(int x : nums){
            res1 += Math.abs(x - mid);
            res2 += Math.abs(x - mid2); 
        }
        if(n % 2 != 0) return res1;
        return Math.min(res1, res2);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna