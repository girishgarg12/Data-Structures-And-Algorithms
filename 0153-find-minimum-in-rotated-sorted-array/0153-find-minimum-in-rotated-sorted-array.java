class Solution {
    public int findMin(int[] nums) {
        int high=nums.length-1,low=0;
        int res=nums[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<res) res=nums[mid];
            if(nums[mid]>nums[high]) low=mid+1;
            else high=mid-1;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna