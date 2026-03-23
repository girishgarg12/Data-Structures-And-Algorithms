class pair {
    int first;
    long second;
    pair(int first,long second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    int mod=1000000007;
    public int countPaths(int n, int[][] roads) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] x:roads){
            int a=x[0],b=x[1],c=x[2];
            adj.get(a).add(new pair(b,c));
            adj.get(b).add(new pair(a,c));
        }
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->Long.compare(a.second,b.second));
        q.add(new pair(0,0));
        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        int[] ways=new int[n];
        ways[0]=1;
        while(!q.isEmpty()){
            pair p=q.poll();
            int no=p.first;
            long dis=p.second;
            for(pair nei:adj.get(no)){
                int newNo=nei.first;
                long nd=nei.second+dis;
                if(nd<dist[newNo]){
                    dist[newNo]=nd;
                    ways[newNo]=ways[no];
                    q.add(new pair(newNo,nd));
                }
                else if(nd==dist[newNo]){
                    ways[newNo]=(ways[newNo]+ways[no])%mod;
                }
            }
        }
        return ways[n-1];
    }
}