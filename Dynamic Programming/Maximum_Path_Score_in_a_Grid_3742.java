class Solution {
    public int dfs(int[][] grid,int i,int j,int k,int[][][] memo,int[] cost,int[] score){
        if(i>=grid.length || j>=grid[0].length) return Integer.MIN_VALUE;
        if(k<cost[grid[i][j]]) return Integer.MIN_VALUE;
        if(i==grid.length-1 && j==grid[0].length-1){
           return score[grid[i][j]];
        }
        if(memo[i][j][k]!=-1) return memo[i][j][k];
        memo[i][j][k]=score[grid[i][j]]+Math.max(dfs(grid,i+1,j,k-cost[grid[i][j]],memo,cost,score),dfs(grid,i,j+1,k-cost[grid[i][j]],memo,cost,score));
        return memo[i][j][k];
    }
    public int maxPathScore(int[][] grid, int k) {
        int n=grid.length,m=grid[0].length;
        int[][][] memo=new int[n][m][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) Arrays.fill(memo[i][j],-1);
        }
        int[] cost=new int[]{0,1,1};
        int[] score=new int[]{0,1,2};
        int res = dfs(grid,0,0,k,memo,cost,score);
        return (res<0)?-1:res;
    }
}