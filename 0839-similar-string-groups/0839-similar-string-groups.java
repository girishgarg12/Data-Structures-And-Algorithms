class Solution {
    class UnionFind {
        int[] rank;
        int[] parent;
        UnionFind(int n){
            rank=new int[n];
            parent=new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }
        public void union(int x,int y){
            int par_x=find(x);
            int par_y=find(y);
            if(par_x==par_y) return;
            if(rank[par_x]<rank[par_y]){
                parent[par_x]=par_y;
            }
            else if(rank[par_x]>rank[par_y]){
                parent[par_y]=par_x;
            }
            else{
                parent[par_y]=par_x;
                rank[par_x]++;
            }
        }
        public int find(int x){
            if(parent[x]==x) return x;
            parent[x]=find(parent[x]);
            return parent[x];
        }
    }
    public boolean isSame(String s1,String s2){
        if(s1.equals(s2)) return true;
        StringBuilder sb=new StringBuilder(s1);
        int c=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) c++;
        }
        if(c==2) return true;
        return false;
    }
    public int numSimilarGroups(String[] strs) {
        int n=strs.length;
        UnionFind u=new UnionFind(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(isSame(strs[i],strs[j])){
                        u.union(i,j);
                    }
                }
            }
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(u.find(i));
        }
        return set.size();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna