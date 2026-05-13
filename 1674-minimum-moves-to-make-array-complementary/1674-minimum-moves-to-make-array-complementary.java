class Solution {
    public int minMoves(int[] nums, int limit) {
        int n=nums.length;
        int[] diff=new int[limit*2+2];
        for(int i=0;i<n/2;i++){
            int a=nums[i],b=nums[n-i-1];
            int minVal=Math.min(a,b)+1;
            int maxVal=Math.max(a,b)+limit;
            diff[2]+=2;diff[2*limit+1]-=2;
            diff[minVal]+=-1;diff[maxVal+1]-=-1;
            diff[a+b]+=-1;diff[a+b+1]-=-1;
        }
        int res=Integer.MAX_VALUE;
        for(int s=2;s<=limit*2;s++){
            diff[s]+=diff[s-1];
            res=Math.min(res,diff[s]);
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna