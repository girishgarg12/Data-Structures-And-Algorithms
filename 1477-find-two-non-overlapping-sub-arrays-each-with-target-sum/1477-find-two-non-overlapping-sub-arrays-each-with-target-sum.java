class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] pre = new int[n + 1];
        int[] suff = new int[n];
        int l = 0, sum = 0;
        for(int r = 0; r < n; r++){
            sum += arr[r];
            while(sum > target){
                sum -= arr[l];
                l++;
            }
            pre[r + 1] = pre[r];
            if(sum == target) {
                int len = r - l + 1;
                if(pre[r + 1] == 0) {
                    pre[r + 1] = len;
                } 
                else {
                    pre[r + 1] = Math.min(pre[r + 1], len);
                }
            }
        }
        l = n - 1; sum = 0;
        for(int r = n-1; r >= 0; r--){
            sum += arr[r];
            while(sum > target){
                sum -= arr[l];
                l--;
            }
            if(sum == target) {
                if(r == n-1) suff[r] = 1;
                else {
                    suff[r] = (suff[r+1] == 0) ? l - r + 1 : Math.min(suff[r+1], l - r + 1);
                }
            }
            else if(r != n-1) suff[r] = suff[r+1];
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(pre[i] != 0 && suff[i] != 0){
                res = Math.min(res, pre[i] + suff[i]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna