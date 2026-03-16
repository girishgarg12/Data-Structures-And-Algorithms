class Solution {
    public void dfs(List<List<Integer>> adj,int n,boolean[] visited){
        visited[n]=true;
        for(int nei:adj.get(n)){
            if(!visited[nei]){
                dfs(adj,nei,visited);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int x:rooms.get(i)){
                adj.get(i).add(x);
            }
        }
        boolean[] visited=new boolean[n];
        dfs(adj,0,visited);
        for(int i=0;i<n;i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}