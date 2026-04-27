class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m=primes.length;
        int[] i=new int[m];
        long[] next=new long[m];
        int[] dp=new int[n];
        dp[0]=1;
        for(int j=1;j<n;j++){
            long min=Long.MAX_VALUE;
            for(int k=0;k<m;k++){
                next[k]=(long)dp[i[k]]*primes[k];
                min=Math.min(min,next[k]);
            }
            dp[j]=(int)min;
            for(int k=0;k<m;k++){
                if(next[k]==dp[j]) i[k]++;
            }
        }
        return dp[n-1];
    }
}