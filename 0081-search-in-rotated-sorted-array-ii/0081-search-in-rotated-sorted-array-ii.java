class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, h = n-1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[l] && nums[mid] == nums[h]){
                l++;
                h--;
            }
            else if(nums[mid] >= nums[l]){
                if(nums[mid] > target && target >= nums[l]) h = mid-1;
                else l = mid+1;
            }
            else{
                if(nums[mid] < target && nums[h] >= target) l = mid+1;
                else h = mid-1;
            }
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna