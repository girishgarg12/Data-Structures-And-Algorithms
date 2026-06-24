class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, h = n-1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[l]){
                if(target < nums[mid] && target >= nums[l]) h = mid-1;
                else l = mid+1;
            }
            else{
                if(target > nums[mid] && target <= nums[h]) l = mid+1;
                else h = mid-1;
            }
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna