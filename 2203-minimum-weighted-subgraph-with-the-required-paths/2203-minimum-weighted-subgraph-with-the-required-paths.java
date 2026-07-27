class Solution {
    class pair {
        int node;
        long dist;
        pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<pair>> adj = new ArrayList<>();
        List<List<pair>> revadj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
            revadj.add(new ArrayList<>());
        }
        for(int[] x : edges) {
            int a = x[0], b = x[1], c = x[2];
            adj.get(a).add(new pair(b,c));
            revadj.get(b).add(new pair(a,c));
        }
        long[] dist1 = new long[n];
        long[] dist2 = new long[n];
        Arrays.fill(dist1, Long.MAX_VALUE);
        Arrays.fill(dist2, Long.MAX_VALUE);
        PriorityQueue<pair> q = new PriorityQueue<>((a,b) -> Long.compare(a.dist , b.dist));
        q.add(new pair(src1, 0));
        dist1[src1] = 0;

        while(!q.isEmpty()) {
            pair p = q.remove();
            if (p.dist != dist1[p.node]) continue;
            int currN = p.node;
            long dis = p.dist;
            for(pair nei : adj.get(currN)){
                int no = nei.node;
                long d = nei.dist;
                if(d + dis < dist1[no]){
                    dist1[no] = d + dis;
                    q.add(new pair(no, d + dis));
                }
            }
        }

        q.add(new pair(src2, 0));
        dist2[src2] = 0;
        while(!q.isEmpty()){
            pair p = q.remove();
            if (p.dist != dist2[p.node]) continue;
            int currN = p.node;
            long dis = p.dist;
            for(pair nei : adj.get(currN)){
                int no = nei.node;
                long d = nei.dist;
                if(dist2[no] > d + dis) {
                    dist2[no] = d + dis;
                    q.add(new pair(no, d + dis));
                }
            }
        }
        long[] dist3 = new long[n];
        Arrays.fill(dist3, Long.MAX_VALUE);
        q.add(new pair(dest, 0));
        dist3[dest] = 0;
        while(!q.isEmpty()) {
            pair p = q.remove();
            if (p.dist != dist3[p.node]) continue;
            int currN = p.node;
            long dis = p.dist;
            for(pair nei : revadj.get(currN)){
                int no = nei.node;
                long d = nei.dist;
                if(d + dis < dist3[no]){
                    dist3[no] = d + dis;
                    q.add(new pair(no, d + dis));
                }
            }
        }

        long res = Long.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(dist1[i] == Long.MAX_VALUE || dist2[i] == Long.MAX_VALUE || dist3[i] == Long.MAX_VALUE) continue;
            res = Math.min(res, dist1[i] + dist2[i] + dist3[i]);
        }
        return res == Long.MAX_VALUE ? -1 : res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna