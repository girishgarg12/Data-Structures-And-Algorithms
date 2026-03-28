class UnionFind {
    int[] par;
    int[] rank;
    UnionFind(int n){
        par=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++) par[i]=i;
    }
    public void union(int a,int b){
        int par_a=find(a);
        int par_b=find(b);
        if(par_a==par_b) return;
        if(rank[par_a]<rank[par_b]){
            par[par_a]=par_b;
        }
        else if(rank[par_a]>rank[par_b]){
            par[par_b]=par_a;
        }
        else{
            par[par_b]=par_a;
            rank[par_a]++;
        }
    }
    public int find(int x){
        if(x==par[x]) return x;
        par[x]=find(par[x]);
        return par[x];
    }
}
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        UnionFind u=new UnionFind(n);
        int par[]=new int[n];
        Arrays.fill(par,-1);
        int[] ans1=null,ans2=null;
        for(int[] x:edges){
            int a=x[0]-1,b=x[1]-1;
            if(par[b]==-1){
                par[b]=a;
            }
            else{
                ans1=new int[]{par[b],b};
                ans2=new int[]{a,b};
                x[1]=0;
            }
        }
        for(int[] x:edges){
            int a=x[0]-1,b=x[1]-1;
            if(b==-1) continue;
            if(u.find(a)==u.find(b)){
                if(ans2==null) return new int[]{a+1,b+1};
                return new int[]{ans1[0]+1,ans1[1]+1};
            }
            u.union(a,b);
        }
        return new int[]{ans2[0]+1,ans2[1]+1};
    }
}