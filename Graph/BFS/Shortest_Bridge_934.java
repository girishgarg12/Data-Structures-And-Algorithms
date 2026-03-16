class triple {
    int first;
    int second;
    int third;
    triple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    Queue<triple> q=new ArrayDeque<>();
    public void dfs(int[][] grid,int i,int j,boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)   return;
        if(visited[i][j] || grid[i][j]==0)   return;
        visited[i][j]=true;
        q.add(new triple(i,j,0));
        dfs(grid,i+1,j,visited);
        dfs(grid,i-1,j,visited);
        dfs(grid,i,j+1,visited);
        dfs(grid,i,j-1,visited);
    }
    public int shortestBridge(int[][] grid) {
        int n=grid.length;
        boolean[][] visited=new boolean[n][n];
        for(int i=0;i<n;i++){
            boolean fl=false;
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    fl=true;
                    dfs(grid,i,j,visited);
                    break;
                }
            }
            if(fl) break;
        }
        int[] r=new int[]{-1,0,1,0};
        int[] c=new int[]{0,1,0,-1};
        int res=n*n;
        while(!q.isEmpty()){
            triple t=q.poll();
            int dis=t.third;
            int rw=t.first;
            int cl=t.second;
            for(int i=0;i<4;i++){
                int nr=rw+r[i];
                int nc=cl+c[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    if(grid[nr][nc]==0){
                        q.add(new triple(nr,nc,dis+1));
                    }
                    else{
                        res=Math.min(res,dis);
                    }
                }
            }
        }
        return res;
    }
}