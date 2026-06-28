class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int res = 1;
        arr[0] = 1;
        for(int i = 1; i < arr.length; i++){
            if(Math.abs(arr[i] - arr[i-1]) > 1) arr[i] = arr[i-1] + 1;
            res = Math.max(arr[i], res);
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna