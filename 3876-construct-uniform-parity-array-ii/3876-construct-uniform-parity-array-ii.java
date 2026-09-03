class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int o = 0, e = 0, minOdd = Integer.MAX_VALUE, minEven = Integer.MAX_VALUE;
        for(int x : nums1){
            if(x % 2 == 0){
                e++;
                minEven = Math.min(minEven, x);
            }
            else {
                minOdd = Math.min(x, minOdd);
                o++;
            }
        }
        if(o == 0 || e == 0) return true;
        return (minOdd < minEven);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna