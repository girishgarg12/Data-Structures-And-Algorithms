class Solution {
    class pair {
        int idx, num;
        pair(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
    class UnionFind {
        int[] par;
        int[] rank;
        boolean[] active;
        PriorityQueue<Integer>[] pq;
        UnionFind(int n, int[] nums) {
            par = new int[n];
            rank = new int[n];
            active = new boolean[n];
            pq = new PriorityQueue[n];
            for(int i = 0; i < n; i++){
                par[i] = i;
                active[i] = true;
                pq[i] = new PriorityQueue<>((a,b) -> Integer.compare(nums[a], nums[b]));
                pq[i].add(i);
            }
        }
        public void union(int a, int b) {
            if(!active[a] || !active[b]) return;
        
            int parA = find(a);
            int parB = find(b);
            if(parA == parB) return;
            if(rank[parA] < rank[parB]){
                par[parA] = parB;
                pq[parB].addAll(pq[parA]);
                pq[parA].clear();
            }
            else if(rank[parB] < rank[parA]){
                par[parB] = parA;
                pq[parA].addAll(pq[parB]);
                pq[parB].clear();
            }
            else{
                par[parA] = parB;
                pq[parB].addAll(pq[parA]);
                pq[parA].clear();
                rank[parB]++;
            }
        }
        public int find(int x){
            if(par[x] == x) return x;
            par[x] = find(par[x]);
            return par[x];
        }
        public int min(int x, int[] nums){
            int root = find(x);
            int res = pq[root].poll();
            return res;
        }
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        pair[] temp = new pair[n];
        for(int i = 0; i < n; i++){
            temp[i] = new pair(i, nums[i]);
        }
        Arrays.sort(temp, (a,b) -> a.num - b.num);

        UnionFind u = new UnionFind(n, nums);
        for(int i = 1; i < n; i++){
            if(Math.abs(temp[i].num - temp[i-1].num) <= limit) u.union(temp[i].idx, temp[i-1].idx);
        }
        int[] res = new int[n];
        int idx = 0;
        for(int i = 0; i < n; i++){
            int minI = u.min(i, nums);
            res[idx++] = nums[minI];
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna