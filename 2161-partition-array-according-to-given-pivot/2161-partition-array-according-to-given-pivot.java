class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int countOfEquals = 0, i=0;
        int[] res = new int[n];
        for(int x : nums){
            if(x < pivot) res[i++] = x;
            if(x == pivot) countOfEquals++;
        }
        while(countOfEquals > 0){
            res[i++] = pivot;
            countOfEquals--;
        }
        for(int x : nums){
            if(x > pivot) res[i++] = x;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna