class Solution {
    public int[] maxValue(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        int[] suff=new int[n];
        pre[0]=nums[0];
        suff[n-1]=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            pre[i]=Math.max(pre[i-1],nums[i]);
        }
        for(int i=n-2;i>=0;i--){
            suff[i]=Math.min(suff[i+1],nums[i+1]);
        }
        int[] res=new int[n];
        for(int i=n-1;i>=0;i--){
            if(pre[i]<=suff[i]) res[i]=pre[i];
            else res[i]=res[i+1];
        }
        return res;
    }
}