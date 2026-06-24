class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int l = 0, h = n-1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(mid > 0 && mid < n-1){
                if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
                else if(nums[mid] > nums[mid+1]) h = mid-1;
                else l = mid+1;
            }
            else if(mid == 0){
                if(nums[mid] > nums[mid+1]) return mid;
                l = mid+1;
            }
            else if(mid == n-1){
                if(nums[mid] > nums[mid-1]) return mid;
                h = mid-1;
            }
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna