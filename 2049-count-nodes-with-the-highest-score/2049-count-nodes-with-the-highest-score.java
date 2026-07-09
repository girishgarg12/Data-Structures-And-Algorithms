class Solution {
    public void dfs(List<List<Integer>> adj, int u, int parent, int[] subtree){
        subtree[u] = 1;
        for(int v : adj.get(u)){
            if(v != parent){
                dfs(adj, v, u, subtree);
                subtree[u] += subtree[v];
            }
        }
    }
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 1; i < n; i++){
            adj.get(i).add(parents[i]);
            adj.get(parents[i]).add(i);
        }
        int[] subtree = new int[n];
        dfs(adj, 0, -1, subtree);
        long res = 0; int count = 0;
        for(int i = 0; i < n; i++){
           long prod = 1;
           if(parents[i] != -1) prod = n - subtree[i];
           for(int child : adj.get(i)){
                if(child != parents[i]){
                    prod *= subtree[child];
                }
            }
            if(prod > res){
                res = prod;
                count = 0;
            }
            if(prod == res) count++;
        }
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna