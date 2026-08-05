class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int res = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            int x = 0, y = 0;
            for(int j = i; j < n; j++){
                if(nums[j] % 2 == 0) x++;
                else y++;
                if(x*b <= y*a) res++;
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna