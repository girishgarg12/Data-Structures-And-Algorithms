class Solution {
    public int dp(int[][] grid,int i,int j,Integer[][] memo){
        if(i>=grid.length || j>=grid[0].length) return Integer.MAX_VALUE;
        if(i==grid.length-1 && j==grid[0].length-1){
            return Math.max(1,1-grid[i][j]);
        }
        if(memo[i][j]!=null) return memo[i][j];
        int r=dp(grid,i,j+1,memo);
        int d=dp(grid,i+1,j,memo);
        int res=Math.min(r,d)-grid[i][j];
        return memo[i][j]=Math.max(1,res);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length,m=dungeon[0].length;
        Integer[][] memo=new Integer[n][m];
        return dp(dungeon,0,0,memo);
    }
}