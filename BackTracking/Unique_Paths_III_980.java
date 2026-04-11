class Solution {
    public int dfs(int[][] grid,int i,int j,int c,int zeros,boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return 0;
        if(grid[i][j]==-1 || visited[i][j]) return 0;
        if(grid[i][j]==2){
            if(c==zeros) return 1;
            return 0;
        }
        visited[i][j]=true;
        int res=dfs(grid,i+1,j,c+1,zeros,visited) +dfs(grid,i-1,j,c+1,zeros,visited) +dfs(grid,i,j+1,c+1,zeros,visited) +dfs(grid,i,j-1,c+1,zeros,visited);
        visited[i][j]=false;
        return res;
    }
    public int uniquePathsIII(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int r=0,c=0,zeros=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    r=i;
                    c=j;
                }
                if(grid[i][j]==0 || grid[i][j]==1) zeros++;
            }
        }
        return dfs(grid,r,c,0,zeros,visited);
    }
}