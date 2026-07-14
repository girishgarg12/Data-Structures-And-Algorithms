class Solution {
    int mod = 1000000007;
    public int minimumCost(int[] nums, int k) {
        int n = nums.length;
        int res = 0; long c = 1;
        int resources = k;
        for(int i = 0; i < n; i++){
            if(resources >= nums[i]) resources -= nums[i];
            else{
                int op = ((nums[i] - resources) + k-1) / k;
                long total = (long) resources + (long) op * k;
                resources = (int)(total - nums[i]);
                long n1 = c + op - 1;
                long cost = ((long)(n1 - c + 1) * (c + (long)n1) / 2) % mod;
                res = (res + (int)cost) % mod;
                c = (c+op) % mod;
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna