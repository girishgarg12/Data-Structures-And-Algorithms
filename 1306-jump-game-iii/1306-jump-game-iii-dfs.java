class Solution {
    public boolean solve(int[] arr,int i,boolean[] visited){
        if(i<0 || i>=arr.length) return false;
        if(arr[i]==0) return true;
        if(visited[i]) return false;
        visited[i]=true;
        return solve(arr,i+arr[i],visited) || solve(arr,i-arr[i],visited);
    }
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean[] visited=new boolean[n];
        return solve(arr,start,visited);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna