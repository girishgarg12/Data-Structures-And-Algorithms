class Solution {
    public int dfs(int[][] grid,int i,int j,boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)   return 1;
        if(grid[i][j]==0)   return 1;
        if(visited[i][j])   return 0;
        visited[i][j]=true;
        return dfs(grid,i+1,j,visited)+dfs(grid,i-1,j,visited)+dfs(grid,i,j+1,visited)+dfs(grid,i,j-1,visited);
    }
    public int islandPerimeter(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return dfs(grid,i,j,visited);
                }
            }
        }
        return -1;
    }
}