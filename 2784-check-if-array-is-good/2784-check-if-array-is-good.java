class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int c=0;
        for(int x:nums){
            int abs=Math.abs(x);
            if(abs>n) continue;
            nums[abs-1]=(nums[abs-1]<0)?1*nums[abs-1]:-1*nums[abs-1];
            if(abs==n-1) c++;
        }
        int c2=0;
        for(int x:nums){
            if(x>0) c2++;
        }
        if(c2!=1 || c!=2) return false;
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna