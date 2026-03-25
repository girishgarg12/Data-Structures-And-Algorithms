class pair {
    int first;
    int second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
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
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] x:redEdges){
            int a=x[0],b=x[1];
            adj.get(a).add(new pair(b,1));
        }
        for(int[] x:blueEdges){
            int a=x[0],b=x[1];
            adj.get(a).add(new pair(b,0));
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        Queue<triple> q=new ArrayDeque<>();
        q.add(new triple(0,0,-1));
        boolean[][] visited=new boolean[n][2];
        while(!q.isEmpty()){
            triple t=q.poll();
            int no=t.first;
            int dis=t.second;
            int col=t.third;
            for(pair nei:adj.get(no)){
                int newno=nei.first;
                int newcol=nei.second;
                if(newcol!=col && !visited[newno][newcol]){
                    visited[newno][newcol]=true;
                    dist[newno]=Math.min(dis+1,dist[newno]);
                    q.add(new triple(newno,dis+1,newcol));
                }
            }
        }
        for(int i=0;i<n;i++) if(dist[i]==Integer.MAX_VALUE) dist[i]=-1;
        return dist;
    }
}