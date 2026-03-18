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
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        Queue<triple> q=new ArrayDeque<>();
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new triple(0,i,j));
                    dist[i][j]=0;
                }
            }
        }
        int[] r=new int[]{-1,0,1,0};
        int[] c=new int[]{0,1,0,-1};
        int res=-1;
        while(!q.isEmpty()){
            triple t=q.poll();
            int dis=t.first;
            int rw=t.second;
            int cl=t.third;
            for(int i=0;i<4;i++){
                int nr=rw+r[i];
                int nc=cl+c[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n ){
                    int nd=dis+1;
                    if(nd<dist[nr][nc] && grid[nr][nc]==0){
                        dist[nr][nc]=nd;
                        res=Math.max(res,nd);
                        q.add(new triple(nd,nr,nc));
                    }
                }
            }
        }
        return res;
    }
}