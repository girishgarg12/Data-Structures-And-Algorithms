class truple {
    int first;
    int second;
    int third;
    truple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=grid[0][0];
        PriorityQueue<truple> pq=new PriorityQueue<>((a,b)->a.first-b.first);
        pq.add(new truple(grid[0][0],0,0));
        int[] r=new int[]{-1,0,1,0};
        int[] c=new int[]{0,1,0,-1};
        while(!pq.isEmpty()){
            truple t=pq.poll();
            int dis=t.first;
            int rw=t.second;
            int cl=t.third;

            if(rw==n-1 && cl==n-1)  return dis;
            for(int i=0;i<4;i++){
                int nr=rw+r[i];
                int nc=cl+c[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n){
                    int nd=Math.max(dis,grid[nr][nc]);
                    if(nd<dist[nr][nc]){
                        dist[nr][nc]=nd;
                        pq.add(new truple(nd,nr,nc));
                    }
                }
            }
        }
        return -1;
    }
}