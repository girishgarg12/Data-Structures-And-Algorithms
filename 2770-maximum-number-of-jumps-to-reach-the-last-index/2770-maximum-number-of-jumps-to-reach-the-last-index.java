class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n=nums.length;
        int[] res=new int[n];
        Arrays.fill(res,-1);
        res[0]=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int diff=nums[j]-nums[i];
                if(diff>=-target && diff<=target && res[j]!=-1) res[i]=Math.max(res[j]+1,res[i]);
            }
        }
        return res[n-1]==0?-1:res[n-1];
    }
}