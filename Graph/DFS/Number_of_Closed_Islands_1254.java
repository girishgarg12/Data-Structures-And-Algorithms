class Solution {
    public boolean dfs(int[][] grid,int i,int j,boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return false;
        if(grid[i][j]==1 || visited[i][j]) return true;
        visited[i][j]=true;
        boolean p1=dfs(grid,i+1,j,visited);
        boolean p2=dfs(grid,i-1,j,visited);
        boolean p3=dfs(grid,i,j+1,visited);
        boolean p4=dfs(grid,i,j-1,visited);
        return p1 && p2 && p3 && p4;
    }
    public int closedIsland(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int res=0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(!visited[i][j] && grid[i][j]==0){
                    if(dfs(grid,i,j,visited)) res++;
                }
            }
        }
        return res;
    }
}