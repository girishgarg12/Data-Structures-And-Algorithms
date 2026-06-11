class Solution {
    int mod = 1000000007;
    private int dfs(int u, int prev, List<List<Integer>> adj) {
        int ans = 0;
        for(int v : adj.get(u)) {
            if(v != prev) {
                ans = Math.max(ans, dfs(v, u, adj) + 1);
            }
        }
        return ans;
    }
    private long pow(long base, int exp) {
        long res = 1;
        while (exp > 0) {
            if (exp % 2 > 0)
                res = res * base % mod;
            base = base * base % mod;
            exp /= 2;
        }
        return res;
    }
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int maxDepth = dfs(1, 0, adj);
        return (int) pow(2, maxDepth - 1);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna