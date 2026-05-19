class Solution {
    class UnionFind {
        public int[] rank;
        public int[] parent;
        UnionFind(int n){
            rank=new int[n];
            parent=new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }
        public void union(int a,int b){
            int par_a=find(a);
            int par_b=find(b);
            if(par_a == par_b) return;
            if(rank[par_a]<rank[par_b]){
                parent[par_a]=par_b;
            }
            else if(rank[par_a]>rank[par_b]){
                parent[par_b] = par_a;
            }
            else{
                parent[par_b]=par_a;
                rank[par_a]++;
            }
        }
        public int find(int x){
            if(x==parent[x]) return x;
            parent[x]=find(parent[x]);
            return parent[x];
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind Alice=new UnionFind(n);
        UnionFind Bob=new UnionFind(n);
        int res=0;
        for(int[] x:edges){
            int a=x[0], b=x[1]-1, c=x[2]-1;
            if(a==3){
                if(Alice.find(b)==Alice.find(c) && Bob.find(b)==Bob.find(c)){
                    res++;
                    continue;
                }
                Alice.union(b,c);
                Bob.union(b,c);
            }
        }
        for(int[] x:edges){
            int a=x[0], b=x[1]-1, c=x[2]-1;
            if(a==3) continue;
            else if(a==2){
                if(Bob.find(b)==Bob.find(c)){
                    res++;
                    continue;
                }
                Bob.union(b,c);
            }
            else{
                if(Alice.find(b)==Alice.find(c)){
                    res++;
                    continue;
                }
                Alice.union(b,c);
            }
        }
        int p1=Alice.find(0),p2=Bob.find(0);
        for(int i=1;i<n;i++){
            if(Alice.find(i)!=p1) return -1;
            if(Bob.find(i)!=p2) return -1;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna