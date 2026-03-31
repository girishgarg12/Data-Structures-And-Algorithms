class pair {
    int first;
    int second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int res=Integer.MAX_VALUE;
    public void dfs(List<List<pair>> adj,int n,boolean[] visited){
        visited[n]=true;
        for(pair nei:adj.get(n)){
            int no=nei.first;
            int dis=nei.second;
            res=Math.min(res,dis);
            if(!visited[no]){
                dfs(adj,no,visited);
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] x:roads){
            int a=x[0]-1,b=x[1]-1,c=x[2];
            adj.get(a).add(new pair(b,c));
            adj.get(b).add(new pair(a,c));
        }
        boolean[] visited=new boolean[n];
        dfs(adj,0,visited);
        return res;
    }//
}