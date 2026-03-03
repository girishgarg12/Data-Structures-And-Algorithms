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
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length,m=heights[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++)    Arrays.fill(dist[i],Integer.MAX_VALUE);
        dist[0][0]=0;
        int[] r=new int[]{-1,0,1,0};
        int[] c=new int[]{0,1,0,-1};
        PriorityQueue<truple> q=new PriorityQueue<>((a,b)->a.first-b.first);
        q.add(new truple(0,0,0));
        while(!q.isEmpty()){
            truple t=q.poll();
            int d=t.first;
            int row=t.second;
            int col=t.third;

            if(row==n-1 && col==m-1)    return d; // we return here because PQ already chose the smallest value and all the other ones must be greater than this thus this is the minimum effort path
            for(int i=0;i<4;i++){
                int nr=row+r[i];
                int nc=col+c[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m ){
                    int minEffort=Math.max(
                        Math.abs(heights[row][col]-heights[nr][nc]),d
                    );
                    if(minEffort<dist[nr][nc]){
                        dist[nr][nc]=minEffort;
                        q.add(new truple(minEffort,nr,nc));
                    }
                }
            }
        }
        return 0;
    }
}