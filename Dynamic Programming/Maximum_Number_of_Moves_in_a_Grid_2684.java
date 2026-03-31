class Solution {
    public int dfs(int[][] grid,int i,int j,int prev,int[][] memo){
        if(i<0 || i>=grid.length || j>=grid[0].length) return 0;
        if(grid[i][j]<=prev) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        memo[i][j]=1+Math.max(dfs(grid,i-1,j+1,grid[i][j],memo),Math.max(dfs(grid,i,j+1,grid[i][j],memo),dfs(grid,i+1,j+1,grid[i][j],memo)));
        return memo[i][j];
    }
    public int maxMoves(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[][] memo=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(memo[i],-1);
        int res=0;
        for(int i=0;i<n;i++){
            res=Math.max(res,dfs(grid,i,0,-1,memo)-1);
        }
        return res;
    }
}