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
    public int minimumTime(int[][] grid) {
        if(grid[0][1]>1 && grid[1][0]>1)    return -1;
        int n=grid.length,m=grid[0].length;
        PriorityQueue<triple> pq=new PriorityQueue<>((a,b)->a.first-b.first);
        pq.add(new triple(0,0,0));
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++)    Arrays.fill(dist[i],Integer.MAX_VALUE);
        int[] r=new int[]{-1,0,1,0};
        int[] c=new int[]{0,1,0,-1};
        while(!pq.isEmpty()){
            triple t=pq.poll();
            int dis=t.first;
            int rw=t.second;
            int cl=t.third;
            if(rw==n-1 && cl==m-1)  return dis;
            for(int i=0;i<4;i++){
                int nr=rw+r[i];
                int nc=cl+c[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m ){
                    int nt=Math.max(dis+1,grid[nr][nc]);
                    if((nt-(dis+1))%2!=0) nt++;
                    if(dist[nr][nc]>nt){
                        dist[nr][nc]=nt;
                        pq.add(new triple(nt,nr,nc));
                    }
                }
            }
        }
        return -1;
    }
}