class Solution {
    public int getDivSum(int[] nums, int div){
        int res = 0;
        for(int x:nums){
            res += Math.ceil((double)x/div);
        }
        return res;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int max = nums[0];
        for(int x : nums) max = Math.max(max,x);
        int l = 1, h = max+1;
        int res = 0;
        while(l <= h){
            int mid = l + (h-l)/2;
            int sum = getDivSum(nums,mid);
            if(sum > threshold) l = mid+1;
            else{
                res = mid;
                h = mid - 1;
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna