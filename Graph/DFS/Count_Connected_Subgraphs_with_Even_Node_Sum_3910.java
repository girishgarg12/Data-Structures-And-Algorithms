class Solution {
    public void dfs(List<List<Integer>> adj,int n,boolean[] visited,boolean[] insub){
        visited[n]=true;
        for(int nei:adj.get(n)){
            if(!visited[nei] && insub[nei]){
                dfs(adj,nei,visited,insub);
            }
        }
    }
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        int n=nums.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] x:edges){
            int a=x[0],b=x[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        List<List<Integer>> paths=new ArrayList<>();
        int res=0;
        for(int i=0;i<Math.pow(2,n);i++){
            int temp=i;
            List<Integer> t=new ArrayList<>();
            int sum=0;
            for(int j=n-1;j>=0;j--){
                if((temp&1)==1){
                    t.add(j);
                    sum+=nums[j];
                }
                temp=temp>>1;
            }
            boolean[] visited=new boolean[n];
            if(t.size()>0 && sum%2==0){
                boolean[] insub=new boolean[n];
                for(int x:t) insub[x]=true;
                dfs(adj,t.get(0),visited,insub);
                boolean flag=true;
                for(int x:t){
                    if(!visited[x]){
                        flag=false;
                        break;
                    }
                }
                if(flag) res++;
            }
        }
        return res;
    }
}