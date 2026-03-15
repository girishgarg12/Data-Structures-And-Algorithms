class Solution {
    public int mod=1000000007;
    public int dfs(int[][] grid,int i,int j,int prev,int[][] memo){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)   return 0;
        if(grid[i][j]<=prev)   return 0;
        if(memo[i][j]!=-1)  return memo[i][j];
        int ans=1;
        ans=(ans+dfs(grid,i+1,j,grid[i][j],memo))%mod;
        ans=(ans+dfs(grid,i-1,j,grid[i][j],memo))%mod;
        ans=(ans+dfs(grid,i,j+1,grid[i][j],memo))%mod;
        ans=(ans+dfs(grid,i,j-1,grid[i][j],memo))%mod;

        return memo[i][j]=ans;
    }
    public int countPaths(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int res=0;
        int[][] memo=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(memo[i],-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res=(res+dfs(grid,i,j,Integer.MIN_VALUE,memo))%mod;
            }
        }
        return res;
    }
}