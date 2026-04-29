class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return  Arrays.asList(0);
        int[] indeg=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] x:edges){
            int a=x[0],b=x[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
            indeg[a]++;
            indeg[b]++;
        }
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==1) q.add(i);
        }
        int nodeleft=n;
        while(nodeleft>2){
            int sz=q.size();
            nodeleft-=sz;
            for(int i=0;i<sz;i++){
                int leaf=q.poll();
                for(int nei:adj.get(leaf)){
                    indeg[nei]--;
                    if(indeg[nei]==1) q.add(nei);
                }
            }
        }
        return new ArrayList<>(q);
    }
}