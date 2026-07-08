class Solution {
    public int mod = 1000000007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length(), m = queries.length;
        int[] sum = new int[n];
        long[] num = new long[n];
        int[] count = new int[n];
        long[] pow = new long[n];
        sum[0] = s.charAt(0) - '0';
        for(int i = 1; i < n; i++){
            int curr = s.charAt(i) - '0';
            sum[i] = sum[i-1] + curr;
        }
        num[0] = s.charAt(0) - '0';
        count[0] = (s.charAt(0) == '0') ? 0 : 1;
        for(int i = 1; i < n; i++){
            int curr = s.charAt(i) - '0';
            if(curr != 0) count[i] = count[i-1] + 1;
            else count[i] = count[i-1];
            if(curr == 0) num[i] = num[i-1];
            else num[i] = (num[i-1] * 10 + curr) % mod;
        }
        pow[0] = 1;
        for(int i = 1; i < n; i++){
            pow[i] = ((1L * pow[i-1] * 10) % mod);
        }

        int[] res = new int[m];
        for(int i = 0; i < m; i++){
            int l = queries[i][0], r = queries[i][1];
            long number = 0, summ = 0;
            if(l == 0){
                number = (int)num[r];
                summ = sum[r];
            }
            else{
                int k = count[r] - count[l-1];
                number = (num[r] - (num[l - 1] * pow[k]) % mod + mod) % mod;
                summ = sum[r] - sum[l-1];
            }
            res[i] = (int)((1L * number * summ) % mod);
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna