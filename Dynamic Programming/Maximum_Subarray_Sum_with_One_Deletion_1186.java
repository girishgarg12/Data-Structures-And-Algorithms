class Solution {
    public int maximumSum(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        int[] maxEnding1=new int[n];
        int[] maxEnding2=new int[n];
        maxEnding1[0]=arr[0];
        maxEnding2[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            maxEnding1[i]=Math.max(maxEnding1[i-1]+arr[i],arr[i]);
        }
        for(int i=n-2;i>=0;i--){
            maxEnding2[i]=Math.max(maxEnding2[i+1]+arr[i],arr[i]);
        }
        int res=arr[0];
        for(int i=0;i<n;i++){
            res=Math.max(res,maxEnding1[i]);
            res=Math.max(res,maxEnding2[i]);
        }
        for(int i=1;i<n-1;i++){
            res=Math.max(res,maxEnding1[i-1]+maxEnding2[i+1]);
            res=Math.max(res,arr[i]);
        }
        res=Math.max(res,Math.max(maxEnding2[1],maxEnding1[n-2]));
        res=Math.max(res,Math.max(arr[0],arr[n-1]));
        return res;
    }
}