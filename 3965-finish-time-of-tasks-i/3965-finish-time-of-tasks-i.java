class Solution {
    public long dfs(List<List<Integer>> adj, int n, int[] baseTime){
        if(adj.get(n).size() == 0) return baseTime[n];
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(int nei : adj.get(n)){
            long p = dfs(adj, nei, baseTime);
            min = Math.min(min,p);
            max = Math.max(max,p);
        }
        return max + ((max - min) + baseTime[n]);
    }
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] x : edges){
            int a = x[0], b = x[1];
            adj.get(a).add(b);
        }
        return dfs(adj,0,baseTime);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna