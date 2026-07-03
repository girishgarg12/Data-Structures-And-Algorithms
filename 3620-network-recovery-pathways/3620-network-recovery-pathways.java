class Solution {
    class pair {
        int first, second;
        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    class truple {
        int node; long sum;
        truple(int node, long sum){
            this.node = node;
            this.sum = sum;
        }
    }
    public boolean canReach(List<List<pair>> adj, int n, int min, long k, boolean[] online){
        PriorityQueue<truple> q = new PriorityQueue<>((a,b) -> Long.compare(a.sum,b.sum));
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        q.add(new truple(0,0));
        while(!q.isEmpty()){
            truple t = q.remove();
            int node = t.node;
            long currSum = t.sum;
            if(currSum > dist[node]) continue;
            if(node == n-1) return true;
            for(pair p :adj.get(node)){
                int nei = p.first;
                int cost = p.second;
                if(cost >= min && currSum+cost <= k && online[nei] && dist[nei] > currSum + cost){
                    dist[nei] = currSum + cost;
                    q.add(new truple(nei, currSum + cost));
                }
            }
        }
        return false;
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        if(edges.length == 0) return -1;
        int n = online.length;
        List<List<pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int[] x : edges){
            int a = x[0], b = x[1], c = x[2];
            adj.get(a).add(new pair(b,c));
            min = Math.min(min, c);
            max = Math.max(max, c);
        }
        int l = min, h = max;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(canReach(adj, n, mid, k, online)) l = mid+1;
            else h = mid-1;
        }
        return (h == min-1) ? -1 : h;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna