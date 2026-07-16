class Solution {
    class pair {
        int b, forward;
        pair(int b, int forward){
            this.b = b;
            this.forward = forward;
        }
    }
    public int res = 0;
    public void dfs(List<List<pair>> adj, int n, boolean[] visited){
        visited[n] = true;
        for(pair p : adj.get(n)){
            if(!visited[p.b]){
                if(p.forward == 1) res++;
                dfs(adj, p.b, visited);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        List<List<pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] x : connections){
            int a = x[0], b = x[1];
            adj.get(a).add(new pair(b,1));
            adj.get(b).add(new pair(a,0));
        }
        boolean[] visited = new boolean[n];
        dfs(adj, 0, visited);
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna