class Solution {
    public int dp(String s,String t,int i,int j,int[][] memo){
        if(j==-1)   return 1;
        if(i==-1)   return 0;
        if(memo[i][j]!=-1)  return memo[i][j];
        if(s.charAt(i)==t.charAt(j))    memo[i][j]=dp(s,t,i-1,j-1,memo)+dp(s,t,i-1,j,memo);
        else{
            memo[i][j]=dp(s,t,i-1,j,memo);
        }
        return memo[i][j];
    }
    public int numDistinct(String s, String t) {
        int n=s.length(),m=t.length();
        int[][] memo=new int[n][m];
        for(int i=0;i<n;i++)    Arrays.fill(memo[i],-1);
        return dp(s,t,n-1,m-1,memo);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna