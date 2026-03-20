class pair {
    int first;
    int second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    int tc=0;
    public void dfs(List<List<pair>> adj,int n,int d,int[] depth,int[] cost,boolean[] visited){
        visited[n]=true;
        depth[n]=d;
        for(pair nei:adj.get(n)){
            if(!visited[nei.first]){
                cost[nei.first]=cost[n]+nei.second;
                tc+=nei.second;
                dfs(adj,nei.first,d+1,depth,cost,visited);
            }
        }
    }
    public int[] minEdgeReversals(int n, int[][] edges) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] x:edges){
            int a=x[0],b=x[1];
            adj.get(a).add(new pair(b,0));
            adj.get(b).add(new pair(a,1));
        }
        int[] depth=new int[n];
        int[] cost=new int[n];
        boolean[] visited=new boolean[n];

        dfs(adj,0,0,depth,cost,visited);
        int[] res=new int[n];
        res[0]=tc;
        for(int i=1;i<n;i++){
            int val1=depth[i]-cost[i];
            int val2=tc-cost[i];
            res[i]=val1+val2;
        }
        return res;
    }
}