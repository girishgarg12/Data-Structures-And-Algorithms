class Solution {
    public int inf=1000000;
    public int dfs(int[][] grid,int i,int j,boolean[][] visited){
        if(grid[i][j]==0)   return 0;
        if(i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1)   return inf;
        if(visited[i][j])   return 0;
        visited[i][j]=true;
        return 1+dfs(grid,i+1,j,visited)+dfs(grid,i-1,j,visited)+dfs(grid,i,j+1,visited)+dfs(grid,i,j-1,visited);
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        if(n<3 || m<3)  return 0;
        int res=0;
        boolean[][] visited=new boolean[n][m];
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    int r=dfs(grid,i,j,visited);
                    res+=(r>=inf)?0:r;
                }
            }
        }
        return res;
    }
}