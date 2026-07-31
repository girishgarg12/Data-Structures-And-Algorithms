class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suff = new int[n];
        pre[0] = 1;
        int c = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] <= nums[i-1]) c++;
            else c = 1;
            pre[i] = c;
        }
        suff[n-1] = 1;
        c = 1;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] <= nums[i+1]) c++;
            else c = 1;
            suff[i] = c;
        }
        List<Integer> res = new ArrayList<>();
        if(k == 0) res.add(0);
        for(int i = 1; i < n-1; i++){
            if(pre[i-1] >= k && suff[i+1] >= k) res.add(i);
        }
        if(k == 0) res.add(n-1);
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna