class Solution {
    int timer=1;
    public void dfs(List<List<Integer>> adj,List<List<Integer>> res,int n,int parent,int[] disc,int[] low,boolean[] visited){
        visited[n]=true;
        disc[n]=low[n]=timer++;
        for(int nei:adj.get(n)){
            if(parent==nei) continue;
            if(!visited[nei]){
                dfs(adj,res,nei,n,disc,low,visited);

                low[n]=Math.min(low[n],low[nei]);
                if(low[nei]>disc[n]){
                    List<Integer> l=new ArrayList<>();
                    l.add(n);l.add(nei);
                    res.add(new ArrayList<>(l));
                }
            }
            else{
                low[n]=Math.min(low[n],disc[nei]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)    adj.add(new ArrayList<>());
        for(List<Integer> l:connections){
            int a=l.get(0),b=l.get(1);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int[] disc=new int[n];
        int[] low=new int[n];
        boolean[] visited=new boolean[n];
        List<List<Integer>> res=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(adj,res,i,-1,disc,low,visited);
            }
        }
        return res;
    }
}