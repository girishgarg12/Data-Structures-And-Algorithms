class UnionFind {
    int[] par;
    int[] rank;
    UnionFind(int n){
        par=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++) par[i]=i;
    }
    public boolean union(int a,int b){
        int aRep=find(a);
        int bRep=find(b);
        if(aRep==bRep) return true;
        if(rank[aRep]<rank[bRep]){
            par[aRep]=bRep;
        }
        else if(rank[aRep]>rank[bRep]){
            par[bRep]=aRep;
        }
        else{
            par[bRep]=aRep;
            rank[aRep]++;
        }
        return false;
    }
    public int find(int x){
        if(x==par[x]) return x;
        par[x]=find(par[x]);
        return par[x];
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        UnionFind u=new UnionFind(n);
        for(int[] x:edges){
            int a=x[0],b=x[1];
            if(u.union(a-1,b-1)) return new int[]{a,b};
        }
        return new int[]{-1,-1};
    }
}