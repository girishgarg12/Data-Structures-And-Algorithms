class Solution {
    public int dfs(int[][] grid,int i,int j,boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)   return 0;
        if(grid[i][j]==0 || visited[i][j])  return 0;
        visited[i][j]=true;
        return 1+dfs(grid,i+1,j,visited)+dfs(grid,i-1,j,visited)+dfs(grid,i,j+1,visited)+dfs(grid,i,j-1,visited);
    }
    public int minDays(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int size=0,noOfComp=0;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    noOfComp++;
                    size=dfs(grid,i,j,visited);
                }
            }
        }
        if(noOfComp==0 || noOfComp>1)   return 0;
        if(size==1) return 1;
        if(size==2)  return 2;
        int[] r=new int[]{-1,0,1,0};
        int[] c=new int[]{0,1,0,-1};
        for(int i=0;i<n;i++){               // Without Articulation Point i am runnigng dfs for every 1 and counting the number of components.
            for(int j=0;j<m;j++){
                if(visited[i][j]){
                    grid[i][j]=0;
                    int count=0;
                    boolean[][] vis=new boolean[n][m];
                    for(int i1=0;i1<n;i1++){
                        for(int j1=0;j1<m;j1++){
                            if(!vis[i1][j1] && grid[i1][j1]==1){
                                count++;
                                if(count>=2)     break;
                                dfs(grid,i1,j1,vis);
                            }
                        }
                    }
                    grid[i][j]=1;
                    if(count>=2)    return 1;
                }
            }
        }
        return 2;
    }
}