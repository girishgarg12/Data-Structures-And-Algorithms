class triple {
    int first,second,third;
    triple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int minCost(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        PriorityQueue<triple> pq=new PriorityQueue<>((a,b)->(a.third-b.third));
        int[] r=new int[]{0,0,1,-1};
        int[] c=new int[]{1,-1,0,0};
        pq.add(new triple(0,0,0));
        dist[0][0]=0;
        while(!pq.isEmpty()){
            triple t=pq.poll();
            int row=t.first;
            int col=t.second;
            int cost=t.third;
            if(cost>dist[row][col]) continue;    //optimization
            if(row==n-1 && col==m-1) return cost;
            for(int i=1;i<=4;i++){
                int nr=row+r[i-1];
                int nc=col+c[i-1];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int ncost=(i!=grid[row][col])?cost+1:cost;
                    if(ncost<dist[nr][nc]){
                        dist[nr][nc]=ncost;
                        pq.add(new triple(nr,nc,ncost));
                    }
                }
            }
        }
        return -1;
    }
}