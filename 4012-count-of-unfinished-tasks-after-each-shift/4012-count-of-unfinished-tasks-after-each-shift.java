class Solution {
    public int bs(long[] sum, long k) {
        int l = 0, r = sum.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(k >= sum[mid]) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length, m = shifts.length;
        long[] sum = new long[n];
        sum[0] = tasks[0];
        for(int i = 1; i < n; i++) sum[i] = sum[i-1] + tasks[i];
        int[] res = new int[m];
        long rem = 0; int lastTask = -1;
        for(int i = 0; i < m; i++){
            long l = (lastTask != -1) ? sum[lastTask] : 0;
            long workRem = shifts[i] + rem + l;
            int ub = bs(sum, workRem);
            if(ub > n-1){
                res[i] = 0;
                rem = 0;
                lastTask = -1;
                continue;
            }
            if(ub == 0){
                res[i] = n;
                rem = workRem;
                lastTask = -1;
                continue;
            }
            res[i] = n - ub;
            rem = workRem - sum[ub - 1];
            lastTask = ub - 1;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna