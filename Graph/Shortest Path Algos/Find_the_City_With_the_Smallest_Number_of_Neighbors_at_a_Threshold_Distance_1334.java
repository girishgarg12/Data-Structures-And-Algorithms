class pair {
    int first;
    int second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)    adj.add(new ArrayList<>());
        for(int[] x:edges){
            int a=x[0],b=x[1],c=x[2];
            adj.get(a).add(new pair(b,c));
            adj.get(b).add(new pair(a,c));
        }
        int res=Integer.MAX_VALUE,num=n+1;
        for(int i=0;i<n;i++){
            Queue<pair> q=new LinkedList<>();
            int c=0;
            int[] dist=new int[n];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[i]=0;
            q.add(new pair(i,0));
            while(!q.isEmpty()){
                pair p=q.poll();
                int node=p.first;
                int dis=p.second;
                for(pair nei:adj.get(node)){
                    int newd=dis+nei.second;
                    int newn=nei.first;
                    if(newd<=distanceThreshold && newd<dist[newn]){
                        if(dist[newn]==Integer.MAX_VALUE) c++;
                        dist[newn]=newd;
                        q.add(new pair(newn,newd));
                    }
                }
            }
            if(c<=num){
                res=i;
                num=c;
            }
        }
        return res;
    }
}