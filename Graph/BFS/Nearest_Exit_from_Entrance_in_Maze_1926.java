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
    public int nearestExit(char[][] maze, int[] entrance) {
        int n=maze.length,m=maze[0].length;
        Queue<triple> q=new ArrayDeque<>();
        q.add(new triple(0,entrance[0],entrance[1]));
        int[] r=new int[]{-1,0,1,0};
        int[] c=new int[]{0,1,0,-1};
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        int res=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            triple t=q.poll();
            int dis=t.first;
            int rw=t.second;
            int cl=t.third;
            if((rw==0 || rw==n-1 || cl==0 || cl==m-1) && (rw!=entrance[0] || cl!=entrance[1])){
                    return dis;
            }
            for(int i=0;i<4;i++){
                int nr=rw+r[i];
                int nc=cl+c[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && maze[nr][nc]!='+' && dis+1<dist[nr][nc]){
                    dist[nr][nc]=dis+1;
                    q.add(new triple(dis+1,nr,nc));
                }
            }
        }
        return -1;
    }
}