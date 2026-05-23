class Solution {
    public boolean check(int[] nums) {
        int start=-1 , n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                start=i;
                break;
            }
        }
        if(start == -1) return true;
        int prev = start;
        for(int i=1;i<n;i++){
            int idx = (start + i) % n;
            if(nums[idx] < nums[prev]) return false;
            prev = idx;
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna