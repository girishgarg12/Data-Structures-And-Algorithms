class Solution {
    public int nthUglyNumber(int n) {
        int[] dp=new int[n];
        dp[0]=1;
        int i2=0,i3=0,i5=0;
        for(int i=1;i<n;i++){
            int n2=dp[i2]*2;
            int n3=dp[i3]*3;
            int n5=dp[i5]*5;
            dp[i]=Math.min(n2,Math.min(n3,n5));
            if(n2==dp[i]) i2++;
            if(n3==dp[i]) i3++;
            if(n5==dp[i]) i5++;
        }
        return dp[n-1];
    }
}