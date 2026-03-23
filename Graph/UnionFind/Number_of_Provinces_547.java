class unionFind {
    private int[] par;
    private int[] rank;
    HashSet<Integer> set=new HashSet<>();
    unionFind(int n){
        par=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    public void union(int a,int b){
        int aRep=find(a);
        int bRep=find(b);
        if(aRep==bRep) return;
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
    }
    public int find(int x){
        if(par[x]==x) return x;
        par[x]=find(par[x]);
        return par[x];
    }
    public int size(){
        for(int i=0;i<par.length;i++) set.add(find(i));
        return set.size();
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        unionFind u=new unionFind(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1) u.union(i,j);
            }
        }
        return u.size();
    }
}