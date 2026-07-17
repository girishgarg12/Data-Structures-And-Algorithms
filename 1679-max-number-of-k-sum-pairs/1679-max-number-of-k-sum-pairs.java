class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, h = n-1;
        int res = 0;
        while(l < h){
            int s = nums[l] + nums[h];
            if(s == k){
                res++;
                l++; h--;
            }
            else if(s < k) l++;
            else h--;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna