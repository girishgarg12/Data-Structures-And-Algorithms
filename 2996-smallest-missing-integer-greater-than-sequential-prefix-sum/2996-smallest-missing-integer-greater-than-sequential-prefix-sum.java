class Solution {
    public int missingInteger(int[] nums) {
        int s = nums[0], n = nums.length;
        boolean Break = false;
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i-1] + 1 && !Break) s += nums[i];
            else Break = true;
            set.add(nums[i]);
        }
        int res = s;
        while(true) {
            if(!set.contains(res)) return res;
            else res++;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna