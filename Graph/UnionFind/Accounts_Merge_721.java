class UnionFind {
    int[] par;
    int[] rank;
    UnionFind(int n){
        par=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        UnionFind u=new UnionFind(n);
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String s=accounts.get(i).get(j);
                if(!map.containsKey(s)){
                    map.put(s,i);
                }
                else{
                    u.union(i,map.get(s));
                }
            }
        }
        List<List<String>> temp=new ArrayList<>();
        for(int i=0;i<n;i++) temp.add(new ArrayList<>());
        for(Map.Entry<String,Integer> e:map.entrySet()){
            String s=e.getKey();
            int node=u.find(e.getValue());
            temp.get(node).add(s);
        }
        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(temp.get(i).size()==0) continue;
            List<String> t=new ArrayList<>();
            for(String s:temp.get(i)) t.add(s);
            Collections.sort(t);
            t.addFirst(accounts.get(i).get(0));
            res.add(new ArrayList<>(t));
        }
        return res;
    }
}