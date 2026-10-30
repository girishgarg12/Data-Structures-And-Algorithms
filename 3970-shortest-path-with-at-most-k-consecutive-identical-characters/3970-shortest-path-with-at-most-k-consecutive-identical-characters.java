class Solution {
    class pair {
        int node, count, w;
        pair(int node , int count, int w) {
            this.node = node;
            this.count = count;
            this.w = w;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] x : edges){
            int a = x[0], b = x[1], c = x[2];
            adj.get(a).add(new int[]{b, c});
        }
        PriorityQueue<pair> q = new PriorityQueue<>((a,b) -> Integer.compare(a.w, b.w));
        int[][] weight = new int[n][k+1];
        for(int i = 0; i < n; i++) Arrays.fill(weight[i], Integer.MAX_VALUE);
        q.add(new pair(0, 1, 0));
        weight[0][1] = 0;
        while(!q.isEmpty()) {
            pair p = q.remove();
            int curr = p.node;
            int count = p.count;
            int w = p.w;
            if(curr == n - 1) return w;
            for(int[] x : adj.get(curr)) {
                int no = x[0];
                int newW = x[1] + w;
                int newCount = (labels.charAt(curr) == labels.charAt(no)) ? count + 1 : 1;
                if(newCount <= k && weight[no][newCount] > newW){
                    q.add(new pair(no, newCount, newW));
                    weight[no][newCount] = newW;
                }
            } 
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna