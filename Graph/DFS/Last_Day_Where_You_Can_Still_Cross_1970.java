class Solution {
    public boolean dfs(int[][] grid,int i,int j,boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return false;
        if(grid[i][j]==1 || visited[i][j]) return false;
        if(i==grid.length-1) return true;
        visited[i][j]=true;
        return dfs(grid,i+1,j,visited) ||
        dfs(grid,i,j+1,visited) ||
        dfs(grid,i,j-1,visited) ||
        dfs(grid,i-1,j,visited);
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n=cells.length;
        int l=0,r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            boolean res=false;
            int[][] grid=new int[row][col];
            for(int i=0;i<=mid;i++){
                grid[cells[i][0]-1][cells[i][1]-1]=1;
            }
            for(int j=0;j<col;j++){
                if(grid[0][j]==0){
                    boolean[][] visited=new boolean[row][col];
                    if(dfs(grid,0,j,visited)){
                        res=true;
                        break;
                    }
                }
            }
            if(res){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return r+1;
    }
}