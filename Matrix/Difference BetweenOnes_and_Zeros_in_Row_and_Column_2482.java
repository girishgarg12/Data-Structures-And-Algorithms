class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int r1=0;
        for(int i=0;i<m;i++)    if(grid[0][i]==1) r1++;

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    grid[0][j]++;
                    if(j!=0)    grid[i][0]++;
                }
            }
        }
        int[][] res=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    res[i][j]=r1+grid[0][j]-(m-r1)-(n-grid[0][j]);
                }
                else{
                    res[i][j]=grid[i][0]+grid[0][j]-(m-grid[i][0])-(n-grid[0][j]);
                }
            }
        }
        return res;
    }
}