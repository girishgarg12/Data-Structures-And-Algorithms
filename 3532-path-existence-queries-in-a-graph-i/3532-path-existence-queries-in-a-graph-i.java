class Solution {
    class unionFind {
        int[] par;
        int[] rank;
        unionFind(int n){
            rank = new int[n];
            par = new int[n];
            for(int i = 0; i < n; i++) par[i] = i;
        }
        public void union(int a, int b){
            int parA = find(a);
            int parB = find(b);
            if(parA == parB) return;
            if(rank[parA] < rank[parB]){
                par[parA] = parB;
            }
            else if(rank[parB] < rank[parA]){
                par[parB] = parA;
            }
            else{
                par[parB] = parA;
                rank[parA]++;
            }
        }
        public int find(int x){
            if(par[x] == x) return x;
            par[x] = find(par[x]);
            return par[x];
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        unionFind u = new unionFind(n);
        for(int i = 1; i < n; i++){
            int a = nums[i-1], b = nums[i];
            if(Math.abs(a-b) <= maxDiff){
                u.union(i-1,i);
            }
        }
        int m = queries.length, i = 0;
        boolean[] res = new boolean[m];
        for(int[] x : queries){
            if(u.find(x[0]) == u.find(x[1])) res[i] = true;
            i++;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna