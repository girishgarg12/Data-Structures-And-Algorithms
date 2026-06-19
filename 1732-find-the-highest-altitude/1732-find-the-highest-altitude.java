class Solution {
    public int largestAltitude(int[] gain) {
        int a=0;
        int max=0;
        for(int i=0;i<gain.length;i++){
            a+=gain[i];
            max=Math.max(a,max);

        }
        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna