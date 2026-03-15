class pair {
    int first;
    int second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)    adj.add(new ArrayList<>());
        for(int[] x:edges){
            int a=x[0],b=x[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int res=Integer.MAX_VALUE;
        for(int st=0;st<n;st++){
            int dist[]=new int[n];
            Arrays.fill(dist,-1);
            dist[st]=0;
            Queue<pair> q=new LinkedList<>();
            q.add(new pair(st,-1));
            while(!q.isEmpty()){
                pair t=q.poll();
                int no=t.first;
                int p=t.second;
                for(int nei:adj.get(no)){
                    if(dist[nei]==-1){
                        dist[nei]=dist[no]+1;
                        q.add(new pair(nei,no));
                    }
                    else if(nei!=p){
                        res=Math.min(res,dist[nei]+dist[no]+1);
                    }
                }
            }
        }
        if(res==Integer.MAX_VALUE)  return -1;
        return res;
    }
}