class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) map.put(arr[i],i);
        int[][] dp=new int[n][n]; // dp[i][j] -> max len fib series ending at index i and j(second last and last)
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int curr=arr[j]-arr[i];
                if(map.containsKey(curr)){
                    int k=map.get(curr);
                    if(k<i){
                        dp[i][j]=1+dp[k][i]; 
                    }
                    else dp[i][j]=2;
                }
                else dp[i][j]=2;
                res=Math.max(dp[i][j],res);
            }
        }
        return (res>2)?res:0;
    }
}