class Solution {
    int id=2;
    HashMap<Integer,Integer> map=new HashMap<>();
    public int dfs(int[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)   return 0;
        if(grid[i][j]!=1)   return 0;
        grid[i][j]=id;
        return 1+dfs(grid,i+1,j)+dfs(grid,i-1,j)+dfs(grid,i,j+1)+dfs(grid,i,j-1);
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int r=dfs(grid,i,j);  // for every 1 i m changing the iland into particular id and storing the size of that island in map with key as id and value as size of island
                    map.put(id,r);
                    id++;
                }
            }
        }
        int[] r={-1,0,1,0};
        int[] c={0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    HashSet<Integer> set=new HashSet<>();
                    int temp=1;
                    for(int k=0;k<4;k++){
                        int nr=i+r[k];
                        int nc=j+c[k];
                        if(nr>=0 && nr<n && nc>=0 && nc<n && map.containsKey(grid[nr][nc]) && !set.contains(grid[nr][nc])){
                            temp+=map.get(grid[nr][nc]);
                            set.add(grid[nr][nc]);
                        }
                    }
                    res=Math.max(res,temp);
                }
            }
        }
        if(res==0)  return n*n;
        return res;
    }
}