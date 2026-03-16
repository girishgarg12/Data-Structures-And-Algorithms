class Solution {
    int[] r=new int[]{-1,0,1,0};
    int[] c=new int[]{0,1,0,-1};
    public int dfs(int[][] grid,int i,int j,boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)   return 0;
        if(grid[i][j]==0 || visited[i][j])  return 0;
        visited[i][j]=true;
        int ans=1;
        for(int i1=0;i1<4;i1++){
            ans+=dfs(grid,i+r[i1],j+c[i1],visited);
        }
        return ans;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    res=Math.max(res,dfs(grid,i,j,visited));
                }
            }
        }
        return res;
    }
}