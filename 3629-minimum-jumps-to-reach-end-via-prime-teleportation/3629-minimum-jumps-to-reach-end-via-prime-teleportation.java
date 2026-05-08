class Solution {
    class pair {
        int first,second;
        pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int minJumps(int[] nums) {
        int n=nums.length;
        int max=nums[0];
        for(int x:nums) max=Math.max(x,max);
        boolean[] isPrime=new boolean[max+1];
        for(int i=2;i<=max;i++) isPrime[i]=true;
        for(int i=2;i*i<=max;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=max;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        boolean[] visited=new boolean[n];
        Queue<pair> q=new ArrayDeque<>();
        visited[0]=true;
        q.add(new pair(0,0));
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                pair p=q.remove();
                int val=nums[p.first];
                int curr=p.first;
                int steps=p.second;
                visited[curr]=true;
                if(curr==n-1) return steps;
                if(curr-1>=0 && !visited[curr-1]) q.add(new pair(curr-1,steps+1));
                if(curr+1<n && !visited[curr+1]) q.add(new pair(curr+1,steps+1));
                if(isPrime[val]){
                    for(int mult=val;mult<=max;mult+=val){
                        if(map.containsKey(mult)){
                            for(int x:map.get(mult)) 
                            if(!visited[x]) q.add(new pair(x,steps+1));
                        }
                    }
                }
            }
        }
        return -1;  
    }
}