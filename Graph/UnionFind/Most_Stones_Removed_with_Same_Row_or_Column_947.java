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
    public int removeStones(int[][] stones) {
        int maxRow=0,maxCol=0;
        int st=0;
        for(int[] x:stones){
            maxRow=Math.max(maxRow,x[0]);
            maxCol=Math.max(maxCol,x[1]);
        }
        UnionFind u=new UnionFind(maxRow+maxCol+2);
        Set<Integer> set=new HashSet<>();
        for(int[] x:stones){
            int row=x[0];
            int col=x[1]+maxRow+1;
            u.union(row,col);
            set.add(row);
            set.add(col);
            st++;
        }
        int conComp=0;
        for(int v:set){
            if(u.find(v)==v){
                conComp++;
            }
        }
        return st-conComp;
    }
}