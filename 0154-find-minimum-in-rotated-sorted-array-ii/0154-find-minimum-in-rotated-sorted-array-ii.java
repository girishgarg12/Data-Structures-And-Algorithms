class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int l=0,h=n-1;
        int res=nums[0];
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]<res) res=nums[mid];
            if(nums[mid]>nums[h]) l=mid+1;
            else if(nums[mid]<nums[l]) h=mid-1;
            else h--;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna