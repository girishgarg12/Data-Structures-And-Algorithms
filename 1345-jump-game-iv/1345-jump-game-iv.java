class Solution {
    class pair {
        int first,second;
        pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int minJumps(int[] arr) {
        int n=arr.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.putIfAbsent(arr[i],new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<pair> q=new ArrayDeque<>();
        boolean[] visited=new boolean[n];
        q.add(new pair(0,0));
        visited[0]=true;
        HashSet<Integer> set=new HashSet<>();
        while(!q.isEmpty()){
            pair p=q.remove();
            int curr=p.first;
            int steps=p.second;
            if(curr==n-1) return steps;
            if(curr-1>=0 && !visited[curr-1]){
                q.add(new pair(curr-1,steps+1));
                visited[curr-1]=true;
            }
            if(curr+1<n && !visited[curr+1]){
                q.add(new pair(curr+1,steps+1));
                visited[curr+1]=true;
            }
            if(set.contains(arr[curr])) continue;
            set.add(arr[curr]);
            for(int x : map.get(arr[curr])){
                if(x!=curr && !visited[x]){
                    q.add(new pair(x,steps+1));
                }
            }
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna