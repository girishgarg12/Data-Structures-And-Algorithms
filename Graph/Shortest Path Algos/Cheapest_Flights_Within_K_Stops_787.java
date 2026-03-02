class truple {
    int st;
    int dest;
    int dist;
    truple(int st,int dest,int dist){
        this.st=st;
        this.dest=dest;
        this.dist=dist;
    }
}
class pair {
    int first;
    int second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)    adj.add(new ArrayList<>());
        for(int[] x:flights){
            int a=x[0],b=x[1],c=x[2];
            adj.get(a).add(new pair(b,c));
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<truple> q=new LinkedList<>();
        q.add(new truple(0,src,0));
        while(!q.isEmpty()){
            truple t=q.poll();
            int stops=t.st;
            int d=t.dest;
            int dis=t.dist;
            if(stops>k) continue;
            for(pair nei:adj.get(d)){
                int adjNode=nei.first;
                int currDis=dis+nei.second;
                if(currDis<dist[adjNode]){   dist[adjNode]=currDis;
                q.add(new truple(stops+1,adjNode,currDis));}
            }
        }
        return (dist[dst]==Integer.MAX_VALUE)?-1:dist[dst];
    }
}
