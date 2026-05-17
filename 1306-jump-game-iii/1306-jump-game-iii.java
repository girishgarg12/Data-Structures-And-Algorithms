class Solution {
    public boolean solve(int[] arr,int i,Boolean[] memo,boolean[] visited){
        if(i<0 || i>=arr.length) return false;
        if(arr[i]==0) return true;
        if(visited[i]) return false;
        if(memo[i]!=null) return memo[i];
        visited[i]=true;
        memo[i] = solve(arr,i+arr[i],memo,visited) || solve(arr,i-arr[i],memo,visited);
        return memo[i];
    }
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        Boolean[] memo=new Boolean[n];
        boolean[] visited=new boolean[n];
        Arrays.fill(memo,null);
        return solve(arr,start,memo,visited);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna