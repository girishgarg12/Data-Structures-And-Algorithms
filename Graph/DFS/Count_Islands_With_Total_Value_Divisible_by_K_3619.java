class Solution {
    public long dfs(int[][] grid,boolean[][] visited,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)   return 0;
        if(grid[i][j]==0)   return 0;
        if(visited[i][j])   return 0;
        visited[i][j]=true;
        return grid[i][j]+dfs(grid,visited,i+1,j)+dfs(grid,visited,i-1,j)+dfs(grid,visited,i,j+1)+dfs(grid,visited,i,j-1);
    }
    public int countIslands(int[][] grid, int k) {
        int n=grid.length,m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0 && !visited[i][j]){
                    if(dfs(grid,visited,i,j)%k==0)  res++;
                }
            }
        }
        return res;
    }
}