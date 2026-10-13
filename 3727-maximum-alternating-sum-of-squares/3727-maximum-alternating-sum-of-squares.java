class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long res = 0;
         Integer[] arr = Arrays.stream(nums)
                              .boxed()
                              .toArray(Integer[]::new);
        Arrays.sort(arr, (a,b) -> Long.compare(Math.abs((long) a), Math.abs((long)b)));
        int mid = n / 2;
        for(int i = 0; i < n; i++){
            if(i < mid) res -= arr[i] * arr[i];
            else res += arr[i] * arr[i];
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna