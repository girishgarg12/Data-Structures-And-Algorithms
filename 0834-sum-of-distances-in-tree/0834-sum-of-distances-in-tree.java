class Solution {
    public void dfs1(List<List<Integer>> adj, int u, int parent, int[] subtree, int[] sum){
        subtree[u] = 1;
        for(int v : adj.get(u)){
            if(v != parent){
                dfs1(adj, v, u, subtree, sum);
                subtree[u] += subtree[v];
                sum[u] += subtree[v] + sum[v];
            }
        }
    }
    public void dfs2(List<List<Integer>> adj, int u, int parent, int[] res, int[] subtree, int n){
        for(int v : adj.get(u)){
            if(v != parent){
                res[v] = res[u] - subtree[v] + (n - subtree[v]);
                dfs2(adj, v, u, res, subtree, n);
            }
        }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] x : edges){
            int a = x[0], b = x[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int[] subtree = new int[n];
        int[] sum = new int[n];
        int[] res = new int[n];
        dfs1(adj, 0, -1, subtree, sum);
        res[0] = sum[0];
        dfs2(adj, 0, -1, res, subtree, n);
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna