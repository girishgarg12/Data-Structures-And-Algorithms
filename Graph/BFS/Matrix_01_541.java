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
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length,m=mat[0].length;
        Queue<truple> q=new ArrayDeque<>();
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++)    Arrays.fill(dist[i],Integer.MAX_VALUE);
        int[] r=new int[]{-1,0,1,0};
        int[] c=new int[]{0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new truple(0,i,j));
                    dist[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            truple t=q.poll();
            int dis=t.first;
            int rw=t.second;
            int cl=t.third;
            for(int i=0;i<4;i++){
                int nr=rw+r[i];
                int nc=cl+c[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int nd=dis+1;
                    if(nd<dist[nr][nc]){
                        dist[nr][nc]=nd;
                        q.add(new truple(nd,nr,nc));
                    }
                }
            }
        }
        return dist;
    }
}