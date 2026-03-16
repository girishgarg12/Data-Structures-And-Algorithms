class Solution {
    public void dfs(List<List<Integer>> adj,int n,int t,List<List<Integer>> res,List<Integer> temp){
        temp.add(n);
        if(n==t){
            res.add(new ArrayList<>(temp));
        }
        for(int nei:adj.get(n)){
            dfs(adj,nei,t,res,temp);
        }
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)    adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int x:graph[i]){
                adj.get(i).add(x);
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        dfs(adj,0,n-1,res,new ArrayList<>());
        return res;
    }
}