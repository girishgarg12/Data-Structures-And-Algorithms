class Solution {
    public void dfs1(int[][] grid,int i,int j,boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return;
        if(grid[i][j]==0 || visited[i][j]) return;
        visited[i][j]=true;
        dfs1(grid,i+1,j,visited);
        dfs1(grid,i-1,j,visited);
        dfs1(grid,i,j+1,visited);
        dfs1(grid,i,j-1,visited);
    }
    public boolean dfs2(int[][] grid,int i,int j,boolean[][] visited,boolean[][] vis){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return true;
        if(grid[i][j]==1 && visited[i][j]==false) return false;
        if(grid[i][j]==0 || vis[i][j]) return true;
        vis[i][j]=true;
        boolean p1=dfs2(grid,i+1,j,visited,vis);
        boolean p2=dfs2(grid,i-1,j,visited,vis);
        boolean p3=dfs2(grid,i,j+1,visited,vis);
        boolean p4=dfs2(grid,i,j-1,visited,vis);

        return p1 && p2 && p3 && p4;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid1.length,m=grid1[0].length;
        boolean[][] visited=new boolean[n][m];
         boolean[][] vis=new boolean[n][m];
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid1[i][j]==1)dfs1(grid1,i,j,visited);
                if(!vis[i][j] && visited[i][j] && grid2[i][j]==1 && dfs2(grid2,i,j,visited,vis)) res++;
            }
        }
        return res;
    }
}