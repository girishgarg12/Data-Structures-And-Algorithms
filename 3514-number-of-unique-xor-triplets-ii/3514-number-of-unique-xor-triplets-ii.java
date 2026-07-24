class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        boolean[] pair = new boolean[2048];
        boolean[] triple = new boolean[2048];
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                pair[nums[i] ^ nums[j]] = true;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < pair.length; j++){
                if(pair[j]) triple[nums[i] ^ j] = true;
            }
        }
        int res = 0;
        for(boolean b : triple) if(b) res++;
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna