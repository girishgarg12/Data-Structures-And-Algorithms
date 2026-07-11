class Solution {
    public int nodes = 0, edge = 0;
    public void dfs(List<List<Integer>> adj, int n, boolean[] visited){
        visited[n] = true;
        nodes++;
        for(int nei : adj.get(n)){
            edge++;
            if(!visited[nei]) dfs(adj, nei, visited);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] x : edges){
            int a = x[0], b = x[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                nodes = 0; edge = 0;
                dfs(adj, i, visited);
                if(nodes * (nodes-1) / 2 == edge/2) res++;
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna