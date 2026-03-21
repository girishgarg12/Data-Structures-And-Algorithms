class Solution {
    public void dfs(List<List<Integer>> adj,int n,boolean[] visited){
        visited[n]=true;
        for(int nei:adj.get(n)){
            if(!visited[nei]){
                dfs(adj,nei,visited);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] x:edges){
            int a=x[0],b=x[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] visited=new boolean[n];
        dfs(adj,source,visited);
        return visited[destination];
    }
}