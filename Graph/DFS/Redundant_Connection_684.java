class Solution {
    public boolean dfs(List<List<Integer>> adj,int src,int target,boolean[] visited){
        if(src==target) return true;
        visited[src]=true;
        for(int nei:adj.get(src)){
            if(!visited[nei]){
                if(dfs(adj,nei,target,visited)) return true;
            }
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)    adj.add(new ArrayList<>());
        for(int[] x:edges){
            int a=x[0],b=x[1];
            boolean[] visited=new boolean[n+1];
            if(dfs(adj,a,b,visited))    return x; 
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        return new int[2];
    }
}