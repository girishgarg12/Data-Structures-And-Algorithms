class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        boolean[] arr1 = new boolean[n];
        int last1 = nums[0], last2 = nums[1];
        arr1[0] = true;
        for(int i = 2; i < n; i++){
            if(last1 > last2){
                arr1[i] = true;
                last1 = nums[i];
            }
            else {
                last2 = nums[i];
            }
        }
        int idx = 0;
        for(int i = 0; i < n; i++){
            if(arr1[i]) res[idx++] = nums[i];
        }
        for(int i = 0; i < n; i++){
            if(!arr1[i]) res[idx++] = nums[i];
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna